package appname.bl.entity;

public class Book {

	private int bookId;// 

	private String name;// 

	private int price;// 
	
	private byte[] cover;
	
	private String coverBase64;
	
	public Book() {
	}

	public Book(int bookId, String name, int price) {
		this.bookId = bookId;
		this.name = name;
		this.price = price;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public byte[] getCover() {
		return cover;
	}

	public void setCover(byte[] cover) {
		this.cover = cover;
	}
	
	public String getCoverBase64() {
		return coverBase64;
	}

	public void setCoverBase64(String coverBase64) {
		this.coverBase64 = coverBase64;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", price=" + price + "]";
	}

}
