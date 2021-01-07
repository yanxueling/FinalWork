
public class Admin {
	private String adminname; //管理员名
	private String password; //密码
	
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		return "Admin [adminname="+adminname+",password="+password+"]";
	}
}
