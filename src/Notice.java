
public class Notice {
	private String headline; //通知标题
	private String content;  //通知内容
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
