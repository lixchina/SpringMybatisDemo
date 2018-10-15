package appname.bl.entity;

public class Book {

	private int bookId;// 

	private String name;// 

	private int number;// 
	
	private byte[] cover;
	
	public Book() {
	}

	public Book(int bookId, String name, int number) {
		this.bookId = bookId;
		this.name = name;
		this.number = number;
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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public byte[] getCover() {
		return cover;
	}

	public void setCover(byte[] cover) {
		this.cover = cover;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", number=" + number + "]";
	}

}
