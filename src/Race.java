import java.util.ArrayList;
import java.util.List;

public class Race {
	private String name;      //��������
	private int number = 0;   //��������
	private String content;   //��������
	private boolean race_if_available; //�����Ƿ�����
	private List<User> usersList = new ArrayList<User>(); //������Ա��Ϣ
	
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isAvailable() {
		return race_if_available;
	}
	public void setAvailable(boolean race_if_available) {
		this.race_if_available = race_if_available;
	}
	public List<User> getUsersList() {
		return usersList;
	}
	public void setUsersList(List<User> usersList) {
		this.usersList = usersList;
	}
	public String toString() {
		return "Race [name=" + name + ", content=" + content + ", race_if_available=" + race_if_available + "]";
	}
	public Race(String name,String content) {
		super();
		this.name = name;
		this.content = content;
	}
	
}
