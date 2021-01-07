
public class User {
	private String username; //用户名
	private String password; //密码
	private boolean user_if_available=true; //判断用户是否可用
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAvailable() {
		return user_if_available;
	}
	public void setAvailable(boolean user_if_available) {
		this.user_if_available = user_if_available;
	}
	
	public String toString() {
		return "User [username="+username+",password="+password+",user_if_available="+user_if_available+"]";
	}
}
