import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class Main {
	    //用户数据集合
		public static List<User> userList=new ArrayList<User>();
		//管理员数据集合
		public static List<Admin>adminList=new ArrayList<Admin>();
		//赛事数据集合
		public static List<Race>raceList=new ArrayList<Race>();
		//通知公告集合
		public static List<Notice> noticeList=new ArrayList<Notice>();
		//赛事成绩集合
		public static List<RaceGrade>raceGradeList=new ArrayList<RaceGrade>();
		public static void main(String[] args) {
			//定义一个管理员账号
			Admin admin=new Admin();
			admin.setAdminname("admin");
			admin.setPassword("123456");
			//添加管理员账号
			adminList.add(admin);
			Scanner input=new Scanner(System.in); 
			
			System.out.println("欢迎来到马拉松赛信息管理系统^-^!");
			
			System.out.println("如果你是用户，1表示注册，2表示登录；如果你是管理员，3表示登录");			
			int index=input.nextInt();
			if(index==1) {
				userRegister();
			}
			else if(index==2) {
				userLogin();
			}
			else if(index==3) {
				adminLogin();
			}
		}

		//用户注册
		public static void userRegister() {
			Scanner input=new Scanner(System.in); 
			String username;
			String password;
			boolean flag=true;
			boolean isExist=true; //判断用户名是否存在
			while(flag) {
				System.out.println("用户名:");
				username=input.nextLine();
				//用户名校验
				for(User user:userList) {
					if(user.getUsername().equals(username)) {
						System.out.println("用户名已存在，请重新输入:");
						isExist=false;
						flag=true;
						break;
					}
				}
				//用户名是否存在
				if(isExist==false) {
					isExist=true; 
				}
				else {
					System.out.println("密码:");
					password=input.nextLine();
					flag=false;
				}
			}
			//封装数据
			User user=new User();
			user.setUsername("username");
			user.setPassword("password");
			userList.add(user);
			
			System.out.println("注册成功!");
			System.out.println("请选择:1、回到主页  2、用户登录  3、退出系统");
			
			int index=input.nextInt();
			if(index==1) {
				main(null);
			}
			else if(index==2) {
				userLogin();
			}
			else if(index==3) {
				exit();
			}
		}

		public static void exit() {
			// TODO Auto-generated method stub
			System.out.println("系统成功退出!");
		}
		
		//用户登录
		public static void userLogin() {
			Scanner input=new Scanner(System.in); 
			String username;
			String password;
			System.out.println("用户名:");
			username=input.nextLine();
			System.out.println("密码:");
			password=input.nextLine();
			boolean isSuccess=false; //判断用户是否成功登录
			for(User user:userList) {
				if(user.getUsername().equals(username)) {
					if(user.getPassword().equals(password)) {
						if(user.isAvailable()==true) {
							isSuccess=true;
						}
						else {
							System.out.println("该账号已被禁用!");
						}
						break;
					}
				}
			}
			if(!isSuccess) {
				System.out.println("登录成功!"+"欢迎你"+username);
			}
			else {
				System.out.println("登录失败！");
				System.out.println("请进行重新登录！");
				userLogin();
			}
			System.out.println("请选择:1、用户首页  2、回到首页  3、退出系统");
			int index=input.nextInt();
			if(index==1) {
				userIndex();
			}
			else if(index==2) {
				main(null);
			}
			else if(index==3) {
				exit();
			}
		}
		
		//管理员登录
		public static void adminLogin() {
			Scanner input=new Scanner(System.in); 
			String adminname;
			String password;
			System.out.println("管理员名:");
			adminname=input.nextLine();
			System.out.println("密码:");
			password=input.nextLine();
			boolean isSuccess=false; //判断用户是否成功登录
			for(Admin admin:adminList) {
				if(admin.getAdminname().equals(adminname)) {
					if(admin.getPassword().equals(password)) {
							isSuccess=true;
						break;
					}
				}
			}
			if(isSuccess) {
				System.out.println("登录成功!"+"欢迎你"+adminname);
			}
			else {
				System.out.println("登录失败！");
				System.out.println("请进行重新登录！");
				adminLogin();
			}
			System.out.println("请选择:1、管理员首页  2、回到首页  3、退出系统");
			int index=input.nextInt();
			if(index==1) {
				adminIndex();
			}
			else if(index==2) {
				main(null);
			}
			else if(index==3) {
				exit();
			}
		}
		
		//用户首页
		public static void userIndex() {
			System.out.println("欢迎来到马拉松赛信息管理系统^-^!");
			System.out.println("请选择:1、比赛报名  2、比赛成绩查询  3、比赛通知  4、返回主页  5、退出系统");
			Scanner input=new Scanner(System.in);
			int index=input.nextInt();
			if(index==1) {
				raceEnroll();
			}
			else if(index==2) {
				raceGrade();
			}
			else if(index==3) {
				raceNotice();
			}
			else if(index==4) {
				main(null);
			}
			else if(index==5) {
				exit();
			}
		}
		//用户比赛报名
		public static void raceEnroll() {
			Scanner input=new Scanner(System.in);
			//获取比赛列表
			System.out.println("请选择你要选择比赛名称:");
			String name=input.nextLine();
			boolean isRaceExist=false;
			Race rc=null;
			for(Race race:raceList) {
				if(race.getName().equals(name)) {
					isRaceExist=true;
					rc=race;
				}
			}
			if(!isRaceExist) {
				System.out.println("赛事不存在，返回用户首页");
				userIndex();
			}
			else {
			//输入您的个人信息
			System.out.println("请输入您的用户名:");
			String username=input.nextLine();
			boolean isExist=false;
			for(User user:userList) {
				if(user.getUsername().equals(username)) {
					isExist=true;
					if(rc!=null) {
					rc.getUsersList().add(user);
					rc.setNumber(rc.getNumber()+1);
						System.out.println("报名成功");
						}
					else {
						System.out.println("报名失败");
					}
				}
			}
			if(!isExist) {
				System.out.println("用户不存在，报名失败");
			}
			}
			System.out.println("返回用户首页");
			userIndex();
		}
		
		//用户比赛成绩查询
		public static void raceGrade() {
			Scanner input=new Scanner(System.in);
			System.out.println("请输入您要查询的比赛:");
			List <RaceGrade> datas = new ArrayList<RaceGrade>() ;
			boolean isRaceExist=false;
			String name=input.nextLine();
			for(RaceGrade data:raceGradeList) {
				if(data.getRace().getName().equals(name)) {
					isRaceExist=true;
				 datas.add(data);
				}
			}
			Collections.sort(datas);

			if(!isRaceExist) {
				System.out.println("赛事不存在或无人报名该赛事");
			}
			else {
				System.out.println("赛事"+name+"排行榜(前10名)如下:");
				int i=1;
			for(RaceGrade raceGrade3:datas) {
				if(i>10)
					break;
				System.out.println("第"+i+"名:"+raceGrade3.getUser().getUsername());
				i++;
			}
			}
			System.out.println("请输入您的用户名:");
			String username=input.nextLine();
			boolean isUserExist=false;
			int i=1;
			System.out.println("赛事"+name);
			for(RaceGrade data:datas) {
				if(data.getUser().getUsername().equals(username)) {
					isUserExist=true;
					System.out.println("您的成绩:"+data.getGrade()+"您的排名:"+i);
					i++;
					break;
				}
			}
			if(!isUserExist)
				System.out.println("未报名该赛事或该用户名不存在");
			System.out.println("请选择：1、继续查询  2、返回用户首页  3、退出系统");
			int index=input.nextInt();
			if(index==1) {
				raceGrade();
			}
			else if(index==2) {
				userIndex();
			}
			else if(index==3) {
				exit();
			}
		}
		
		//用户查看公告
		public static void raceNotice() {
			Scanner input=new Scanner(System.in);
			System.out.println("接下来为您展示最近的比赛通知");
			int i=1;
			for(Notice notice:noticeList) {
				System.out.println("通知"+i+":");
				System.out.println("通知标题:"+notice.getHeadline());
				System.out.println("通知内容:"+notice.getContent());
				i++;
			}
			System.out.println("请选择：1、继续查看  2、返回用户首页  3、退出系统");
			int index=input.nextInt();
			if(index==1) {
				raceNotice();
			}
			else if(index==2) {
				userIndex();
			}
			else if(index==3) {
				exit();
			}
		}
		
		//管理员首页
		public static void adminIndex() {
			Scanner input=new Scanner(System.in);
			System.out.println("欢迎来到马拉松赛信息管理系统的管理员界面");
			System.out.println("请选择:1、账户管理  2、比赛管理  3、成绩管理  4、通知管理  5、返回主页  6、退出系统");
			int index=input.nextInt();
			if(index==1) {
				userManage();
			}
			else if(index==2) {
				raceManage();
			}
			else if(index==3) {
				gradeManage();
			}
	        else if(index==4) {
			    noticeManage();
			}
	        else if(index==5) {
		        main(null);
	        }
	        else if(index==6) {
	            exit();
	        }
		}
		
		//账户管理
		public static void userManage() {
			System.out.println("请选择以下操作:1、查询账户  2、账户禁用  3、重置密码  4、返回管理员首页  5、返回主页  6、退出系统");
			Scanner input=new Scanner(System.in);
			int index=input.nextInt();
			if(index==1) {
				userSelect();
			}
			else if(index==2) {
				userDisabled();
			}
			else if(index==3) {
				resetPassword();
			}
	        else if(index==4) {
	        	adminIndex();
			}
	        else if(index==5) {
	        	main(null);
	        }
	        else if(index==6) {
	        	exit();
	        }
		}
		
		//查询账户
		public static void userSelect() {
			Scanner input=new Scanner(System.in);
			System.out.println("请输入你要查询的用户名:");
			String username=input.nextLine();
			boolean isSuccess=false;
			for(User user:userList) {
				if(user.getUsername().equals(username)) {
					isSuccess=true;
					System.out.println("查询成功");
					System.out.println(user);
					break;
				}
			}
			if(!isSuccess)
			System.out.println("查询失败，无此账号信息!");
			System.out.println("请选择：1、继续查询  2、返回账户管理首页  3、退出系统");
			int index=input.nextInt();
			if(index==1) {
				userSelect();
			}
			else if(index==2) {
				userManage();
			}
			else if(index==3) {
				exit();
			}
		}
		
		//账户禁用
		public static void userDisabled() {
			System.out.println("请输入您要禁用的账户:");
			Scanner input=new Scanner(System.in);
			String username=input.nextLine();
			for(User user:userList) {
				if(user.getUsername().equals(username)) {
					System.out.println("是否确认禁用该用户，1、确认，2、取消");
					int x=input.nextInt();
					if(x==1) {
						user.setAvailable(false);
						System.out.println("禁用成功!");
					}
					else {
						System.out.println("禁用失败!");	
					}
				break;
				}
			}
			System.out.println("请选择：1、继续禁用  2、返回账户管理首页  3、退出系统");
			int index=input.nextInt();
			if(index==1) {
				userDisabled();
			}
			else if(index==2) {
				userManage();
			}
			else if(index==3) {
				exit();
			}
		}

		//重置密码
		public static void resetPassword() {
			System.out.println("请输入你要重置密码的账号:");
			Scanner input=new Scanner(System.in);
			String username=input.nextLine();
			boolean isSuccess=false;
			for(User user:userList) {
				if(user.getUsername().equals(username)) {
					isSuccess=true;
					System.out.println("确认是否重置密码，1、确认，2、取消");
					int index=input.nextInt();
					if(index==1) {
						System.out.println("请输入密码进行重置：");
						String password=input.next();
						user.setPassword(password);
						System.out.println("重置成功");
					}
					else if(index==2) {
						System.out.println("取消重置");
					}

				}
			}
			if(!isSuccess)
				System.out.println("查询失败，无此账号信息！");
			System.out.println("请选择：1、继续重置  2、返回账户管理首页  3、退出系统");
			int index=input.nextInt();
			if(index==1) {
				resetPassword();
			}
			else if(index==2) {
				userManage();
			}
			else if(index==3) {
				exit();
			}
		}
		
		//比赛管理
		public static void raceManage() {
			Scanner input=new Scanner(System.in);
			System.out.println("请选择以下操作:1、添加比赛  2、启停比赛  3、查询报名情况  4、返回管理员首页  5、退出系统");
			int index=input.nextInt();
			if(index==1) {
				insertRace();
			}
			else if(index==2) {
				handleRace();
			}
			else if(index==3) {
				selectRegister();
			}
			else if(index==4) {
				adminIndex();
			}
			else if(index==5) {
				exit();
			}
		}
		
		//添加比赛
		public static void insertRace() {
			Scanner input=new Scanner(System.in);
			System.out.println("请输入比赛名称:");
			String name=input.nextLine();
			System.out.println("请输入比赛内容:");
			String content=input.nextLine();
			System.out.println("是否进行添加，1、确定，2、取消");
			int index =input.nextInt();
			if(index==1) {
				Race race=new Race(name,content);
				raceList.add(race);
				System.out.println("添加比赛成功!");
			}
			System.out.println("请选择：1、继续添加  2、返回比赛管理首页  3、退出系统");
			int index1=input.nextInt();
			if(index1==1) {
				insertRace();
			}
			else if(index1==2) {
				raceManage();
			}
			else if(index1==3) {
				exit();
			}
		}
		
		//启停比赛
		public static void handleRace() {
			Scanner input=new Scanner(System.in);
			System.out.println("请选择您要启停的比赛的名称：");
			String name=input.nextLine();
			boolean isExist=false;
			for(Race race:raceList) {
				if(race.getName().equals(name)) {
					isExist=true;
					System.out.println("请选择开启或者停止比赛，1、开启，2、停止:");
					int index=input.nextInt();
					if(index==1) {
						race.setAvailable(true);
						System.out.println("开启成功!");
					}
					else if(index==2) {
						race.setAvailable(false);
						System.out.println("停止成功!");
					}
				}

			}
			if(!isExist) {
				System.out.println("赛事不存在!");
			}
			System.out.println("请选择：1、继续启停  2、返回比赛管理首页  3、退出系统");
			int index1=input.nextInt();
			if(index1==1) {
				handleRace();
			}
			else if(index1==2) {
				raceManage();
			}
			else if(index1==3) {
				exit();
			}

		}
		
		//查询报名情况
		public static void selectRegister() {
			System.out.println("请输入您要查询的比赛的名称");
			Scanner input=new Scanner(System.in);
			String name=input.nextLine();
			boolean isExist=false;
			for(Race race:raceList) {
				if(race.getName().equals(name)) {
					isExist=true;
					System.out.println("下面是"+race.getName()+"的人员报名情况:");
					System.out.println("一共报名人数:"+race.getNumber());
					for(User user:race.getUsersList()) {
						System.out.println(user);
					}
				}

			}
			if(!isExist) {
				System.out.println("赛事不存在！");
			}
			System.out.println("请选择：1、继续查询  2、返回比赛管理首页  3、退出系统");
			int index=input.nextInt();
			if(index==1) {
				selectRegister();
			}
			else if(index==2) {
				raceManage();
			}
			else if(index==3) {
				exit();
			}
		}
		
		//成绩管理
		public static void gradeManage() {
			Scanner input=new Scanner(System.in);
			System.out.println("请选择以下操作:1、录入比赛成绩  2、查询运动员的成绩和排名  3、查询比赛排行榜  4、返回管理员首页  5、退出系统");
			int index =input.nextInt();
			if(index==1) {
				insertGrade();	
			}
			else if(index==2) {
				selectGrade();
			}
			else if(index==3) {
				selectRank();
			}
			else if(index==4) {
				adminIndex();
			}
			else if(index==5) {
				exit();
			}
		}

		//录入成绩
		public static void insertGrade() {
			Scanner input=new Scanner(System.in);
			System.out.println("请输入比赛名称:");
			String name=input.nextLine();
			boolean isRaceExist=false;
			for(Race race:raceList) {
				if(race.getName().equals(name)) {
					isRaceExist=true;
					boolean isUserExist=false;
					System.out.println("请输入用户名:");
					String username=input.nextLine();
					for(User user:userList) {
						if(user.getUsername().equals(username)) {
							isUserExist=true;
							System.out.println("请输入该用户的成绩:");
							double grade=input.nextDouble();
							RaceGrade raceGrade=new RaceGrade();
							raceGrade.setRace(race);
							raceGrade.setUser(user);
							raceGrade.setGrade(grade);
							raceGradeList.add(raceGrade);
							System.out.println("成绩录入成功!");
							break;
						}	
					}
					if(!isUserExist)
						System.out.println("该用户不存在");
					break;
				}
			}
			if(!isRaceExist) {
				System.out.println("赛事不存在!");
			}
			System.out.println("请选择：1、继续录入  2、返回成绩管理首页  3、退出系统");
			int index=input.nextInt();
			if(index==1) {
				insertGrade();
			}
			else if(index==2) {
				gradeManage();
			}
			else if(index==3) {
				exit();
			}
		}

		//查询运动员成绩和排名
		public static void selectGrade() {
			List <RaceGrade> raceGrade = new ArrayList<RaceGrade>() ;
			Scanner input=new Scanner(System.in);
			System.out.println("请输入赛事的名称:");
			String name=input.nextLine();
			boolean isRaceExist=false;
			for(RaceGrade raceGrade2:raceGradeList) {
				if(raceGrade2.getRace().getName().equals(name)) {
					isRaceExist=true;
				 raceGrade.add(raceGrade2);
				}
			}
			Collections.sort(raceGrade);
			if(!isRaceExist) {
				System.out.println("赛事不存在或无人员报名!");
			}
			else {
				boolean isUserExist=false;
				System.out.println("请输入要查询的用户名:");
				String username=input.nextLine();
				int i=1;
				for(RaceGrade raceGrade3:raceGrade) {
					if(raceGrade3.getUser().getUsername().equals(username)) {
						isUserExist=true;
						System.out.println("查询成功");
						System.out.println("该用户的成绩是:"+raceGrade3.getGrade()+" 排名是:"+"第"+i+"名");
					}
					i++;
				}
				if(!isUserExist) {
					System.out.println("该用户不存在!");
				}
				System.out.println("请选择：1、继续查询  2、返回成绩管理首页  3、退出系统");
				int index=input.nextInt();
				if(index==1) {
					selectGrade();
				}
				else if(index==2) {
					gradeManage();
				}
				else if(index==3) {
					exit();
				}			
			}
		}
		//查询总排行
		public static void selectRank() {
			List <RaceGrade> raceGrade = new ArrayList<RaceGrade>() ;
			Scanner input=new Scanner(System.in);
			System.out.println("请输入你要查询的赛事:");
			String name=input.nextLine();
			boolean isRaceExist=false;
			for(RaceGrade raceGrade2:raceGradeList) {
				if(raceGrade2.getRace().getName().equals(name)) {
					isRaceExist=true;
				 raceGrade.add(raceGrade2);
				}
			}
			Collections.sort(raceGrade);
			if(!isRaceExist) {
				System.out.println("赛事不存在或无人员报名!");
			}
			else {
				System.out.println("赛事"+name+"排行榜如下:");
				int i=1;
			for(RaceGrade raceGrade3:raceGrade) {
				System.out.println("第"+i+"名:"+raceGrade3.getUser().getUsername());
				i++;
			}
			}
			System.out.println("请选择：1、继续查询  2、返回成绩管理首页  3、退出系统");
			int index=input.nextInt();
			if(index==1) {
				selectRank();
			}
			else if(index==2) {
				gradeManage();
			}
			else if(index==3) {
				exit();
			}
		}
		
		//通知管理
		public static void noticeManage() {
			Scanner input=new Scanner(System.in);
			System.out.println("请选择以下操作:1、添加通知  2、更新通知  3、查询通知  4、删除通知  5、返回管理员主页  6、退出系统");
			int index=input.nextInt();
			if(index==1) {
				insertNotice();
			}
			else if(index==2) {
				updateNotice();
			}
			else if(index==3) {
				selectNotice();
			}
			else if(index==4) {
				deleteNotice();
			}
			else if(index==5) {
				adminIndex();
			}
			else if(index==6) {
				exit();
			}
		}
		
		//添加通知
		public static void insertNotice() {
			Scanner input=new Scanner(System.in);
			System.out.println("请输入通知标题:");
			String headline=input.nextLine();
			boolean isNoticeExist=false;
			for(Notice notice:noticeList) {
				if(notice.getHeadline().equals(headline)) {
					isNoticeExist=true;
					System.out.println("该通知已存在!添加失败");
					break;
				}
			}
			if(!isNoticeExist) {
				System.out.println("请输入通知内容:");
				String content=input.nextLine();
			    Notice notice=new Notice();
			    notice.setHeadline(headline);
			    notice.setContent(content);
			    noticeList.add(notice);
			    System.out.println("添加通知成功!");
			}
			System.out.println("请选择：1、继续添加  2、返回通知管理首页  3、退出系统");
			int index=input.nextInt();
			if(index==1) {
				insertNotice();
			}
			else if(index==2) {
				noticeManage();
			}
			else if(index==3) {
				exit();
			}
		}

		//更新通知
		public static void updateNotice() {
			Scanner input=new Scanner(System.in);
			System.out.println("请输入通知的标题:");
			String headline=input.nextLine();
			boolean isNoticeExist=false;
			int i=0;
			for(Notice notice:noticeList) {
				if(notice.getHeadline().equals(headline)) {
					isNoticeExist=true;
					System.out.println("请输入要修改的内容:");
					String content=input.nextLine();
					noticeList.get(i).setContent(content);
					System.out.println("通知修改成功");
				}
				i++;
			}
			if(!isNoticeExist) {
				System.out.println("该通知不存在！");
			}
			System.out.println("请选择：1、继续更新  2、返回通知管理首页  3、退出系统");
			int index=input.nextInt();
			if(index==1) {
				updateNotice();
			}
			else if(index==2) {
				noticeManage();
			}
			else if(index==3) {
				exit();
			}
		}


		//查询通知
		public static void selectNotice() {
			Scanner input=new Scanner(System.in);
			System.out.println("请输入通知的标题:");
			String headline=input.nextLine();
			boolean isNoticeExist=false;
			for(Notice notice:noticeList) {
				if(notice.getHeadline().equals(headline)) {
					isNoticeExist=true;
					System.out.println("查询成功！");
					System.out.println("通知标题:"+notice.getHeadline()+"通知内容:"+notice.getContent());
					break;
				}
			}
			if(!isNoticeExist) {
				System.out.println("该通知不存在！");
			}
			System.out.println("请选择：1、继续查询  2、返回通知管理首页  3、退出系统");
			int index=input.nextInt();
			if(index==1) {
				selectNotice();
			}
			else if(index==2) {
				noticeManage();
			}
			else if(index==3) {
				exit();
			}
		}

		//删除公告
		public static void deleteNotice() {
			Scanner input=new Scanner(System.in);
			System.out.println("请输入通知的标题：");
			String headline=input.nextLine();
			boolean isNoticeExist=false;
			for(Notice notice:noticeList) {
				if(notice.getHeadline().equals(headline)) {
					isNoticeExist=true;
					System.out.println("请确认是否删除该通知，1、确认，2、取消");
					int index=input.nextInt();
					if(index==1){
					noticeList.remove(notice);
					System.out.println("删除成功！");
					}
					else if(index==2){
						System.out.println("取消删除！");
					}
					break;
				}
			}
			if(!isNoticeExist) {
				System.out.println("该通知不存在！");
			}
			System.out.println("请选择：1、继续删除  2、返回通知管理首页  3、退出系统");
			int index1=input.nextInt();
			if(index1==1) {
				deleteNotice();
			}
			else if(index1==2) {
				noticeManage();
			}
			else if(index1==3) {
				exit();
			}
		}
		}
