package appname.web;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;


import appname.bl.entity.Book;
import appname.bl.model.BookForm;

import appname.bl.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BookService bookService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String index(BookForm form) {
        logger.info("index start");
        return "newBook";
    }
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid BookForm form, BindingResult result, Model model, @RequestParam(value="uploadFile",required=false) MultipartFile file) {
    					
        logger.info("create start");

        if (result.hasErrors()) {
            return "newBook";
        }
        
    	//TODO 50000¤Ï¥×¥í¥Ñ¥Æ¥£¥Õ¥¡¥¤¥ë¤è¤êÈ¡µÃ¤¹¤ë¤è¤¦‰ä¸ü
        if (file.getSize() > 50000) {
            result.rejectValue("cover", "error.fileSize",
                    new Object[]{50000},"File size error");
        }
    	
        if (!file.isEmpty()) {
        	byte[] fileContent = null;
            InputStream is = null;
            try {
                is = file.getInputStream();
                fileContent = IOUtils.toByteArray(is);
                form.setCover(fileContent);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                IOUtils.closeQuietly(is);
            }
        }
    	
        Book book = new Book();
        book.setName(form.getBookName());
        book.setPrice(form.getPrice());
        book.setCover(form.getCover());
        bookService.addBook(book);
        model.addAttribute("book", book);
        return "redirect:/book/list";
    }

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private String list(Model model) {
		List<Book> list = bookService.getList();
		model.addAttribute("list", list);
		return "list";
	}


	@RequestMapping(value = "/{bookId}/detail", method = RequestMethod.GET)
	private String detail(@PathVariable("bookId") Integer bookId, Model model) {
		if (bookId == null) {
			return "redirect:/book/list";
		}
		Book book = bookService.getById(bookId);
		if (book == null) {
			return "forward:/book/list";
		}
		model.addAttribute("book", book);
		return "detail";
	}
}
