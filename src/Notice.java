
public class Notice {
	private String headline; //֪ͨ����
	private String content;  //֪ͨ����
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String toString() {
		return "notice [headline=" + headline + ", content=" + content + "]";
	}
}
