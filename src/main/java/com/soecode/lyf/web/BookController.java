package com.soecode.lyf.web;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;

import com.soecode.lyf.dto.AppointExecution;
import com.soecode.lyf.dto.Result;
import com.soecode.lyf.entity.Book;
import com.soecode.lyf.enums.AppointStateEnum;
import com.soecode.lyf.exception.NoNumberException;
import com.soecode.lyf.exception.RepeatAppointException;
import com.soecode.lyf.model.BookForm;
import com.soecode.lyf.service.BookService;

@Controller
@RequestMapping("/book") // url:/Ê®°Âùó/ËµÑÊ∫ê/{id}/ÁªÜÂàÜ /seckill/list
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
        
    	//TODO 50000§œ•◊•Ì•—•∆•£•’•°•§•Î§Ë§Í»°µ√§π§Î§Ë§¶â‰∏¸
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
        book.setCover(form.getCover());
        bookService.addBook(book);
        model.addAttribute("book", book);
        return "result";
    }

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private String list(Model model) {
		List<Book> list = bookService.getList();
		model.addAttribute("list", list);
		// list.jsp + model = ModelAndView
		return "list";// WEB-INF/jsp/"list".jsp
	}

	@RequestMapping(value = "/{bookId}/detail", method = RequestMethod.GET)
	private String detail(@PathVariable("bookId") Long bookId, Model model) {
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

	/*// ajax json
	@RequestMapping(value = "/{bookId}/appoint", method = RequestMethod.POST, produces = {
			"application/json; charset=utf-8" })
	@ResponseBody
	private Result<AppointExecution> appoint(@PathVariable("bookId") Long bookId, @RequestParam("studentId") Long studentId) {
		if (studentId == null || studentId.equals("")) {
			return new Result<>(false, "Â≠¶Âè∑‰∏çËÉΩ‰∏∫Á©∫");
		}
		AppointExecution execution = null;
		try {
			execution = bookService.appoint(bookId, studentId);
		} catch (NoNumberException e1) {
			execution = new AppointExecution(bookId, AppointStateEnum.NO_NUMBER);
		} catch (RepeatAppointException e2) {
			execution = new AppointExecution(bookId, AppointStateEnum.REPEAT_APPOINT);
		} catch (Exception e) {
			execution = new AppointExecution(bookId, AppointStateEnum.INNER_ERROR);
		}
		return new Result<AppointExecution>(true, execution);
	}*/

}
