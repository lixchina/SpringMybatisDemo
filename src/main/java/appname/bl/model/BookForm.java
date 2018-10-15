package appname.bl.model;


import java.io.Serializable;
import org.hibernate.validator.constraints.NotEmpty;

public class BookForm implements Serializable {

    private static final long serialVersionUID = 1L;

    private String bookId;

    @NotEmpty
    private String bookName;

    private String price;
	
    private byte[] cover;

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public byte[] getCover() {
		return cover;
	}

	public void setCover(byte[] cover) {
		this.cover = cover;
	}

    
    
}