import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class Main {
	    //�û����ݼ���
		public static List<User> userList=new ArrayList<User>();
		//����Ա���ݼ���
		public static List<Admin>adminList=new ArrayList<Admin>();
		//�������ݼ���
		public static List<Race>raceList=new ArrayList<Race>();
		//֪ͨ���漯��
		public static List<Notice> noticeList=new ArrayList<Notice>();
		//���³ɼ�����
		public static List<RaceGrade>raceGradeList=new ArrayList<RaceGrade>();
		public static void main(String[] args) {
			//����һ������Ա�˺�
			Admin admin=new Admin();
			admin.setAdminname("admin");
			admin.setPassword("123456");
			//��ӹ���Ա�˺�
			adminList.add(admin);
			Scanner input=new Scanner(System.in); 
			
			System.out.println("��ӭ��������������Ϣ����ϵͳ^-^!");
			
			System.out.println("��������û���1��ʾע�ᣬ2��ʾ��¼��������ǹ���Ա��3��ʾ��¼");			
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

		//�û�ע��
		public static void userRegister() {
			Scanner input=new Scanner(System.in); 
			String username;
			String password;
			boolean flag=true;
			boolean isExist=true; //�ж��û����Ƿ����
			while(flag) {
				System.out.println("�û���:");
				username=input.nextLine();
				//�û���У��
				for(User user:userList) {
					if(user.getUsername().equals(username)) {
						System.out.println("�û����Ѵ��ڣ�����������:");
						isExist=false;
						flag=true;
						break;
					}
				}
				//�û����Ƿ����
				if(isExist==false) {
					isExist=true; 
				}
				else {
					System.out.println("����:");
					password=input.nextLine();
					flag=false;
				}
			}
			//��װ����
			User user=new User();
			user.setUsername("username");
			user.setPassword("password");
			userList.add(user);
			
			System.out.println("ע��ɹ�!");
			System.out.println("��ѡ��:1���ص���ҳ  2���û���¼  3���˳�ϵͳ");
			
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
			System.out.println("ϵͳ�ɹ��˳�!");
		}
		
		//�û���¼
		public static void userLogin() {
			Scanner input=new Scanner(System.in); 
			String username;
			String password;
			System.out.println("�û���:");
			username=input.nextLine();
			System.out.println("����:");
			password=input.nextLine();
			boolean isSuccess=false; //�ж��û��Ƿ�ɹ���¼
			for(User user:userList) {
				if(user.getUsername().equals(username)) {
					if(user.getPassword().equals(password)) {
						if(user.isAvailable()==true) {
							isSuccess=true;
						}
						else {
							System.out.println("���˺��ѱ�����!");
						}
						break;
					}
				}
			}
			if(!isSuccess) {
				System.out.println("��¼�ɹ�!"+"��ӭ��"+username);
			}
			else {
				System.out.println("��¼ʧ�ܣ�");
				System.out.println("��������µ�¼��");
				userLogin();
			}
			System.out.println("��ѡ��:1���û���ҳ  2���ص���ҳ  3���˳�ϵͳ");
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
		
		//����Ա��¼
		public static void adminLogin() {
			Scanner input=new Scanner(System.in); 
			String adminname;
			String password;
			System.out.println("����Ա��:");
			adminname=input.nextLine();
			System.out.println("����:");
			password=input.nextLine();
			boolean isSuccess=false; //�ж��û��Ƿ�ɹ���¼
			for(Admin admin:adminList) {
				if(admin.getAdminname().equals(adminname)) {
					if(admin.getPassword().equals(password)) {
							isSuccess=true;
						break;
					}
				}
			}
			if(isSuccess) {
				System.out.println("��¼�ɹ�!"+"��ӭ��"+adminname);
			}
			else {
				System.out.println("��¼ʧ�ܣ�");
				System.out.println("��������µ�¼��");
				adminLogin();
			}
			System.out.println("��ѡ��:1������Ա��ҳ  2���ص���ҳ  3���˳�ϵͳ");
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
		
		//�û���ҳ
		public static void userIndex() {
			System.out.println("��ӭ��������������Ϣ����ϵͳ^-^!");
			System.out.println("��ѡ��:1����������  2�������ɼ���ѯ  3������֪ͨ  4��������ҳ  5���˳�ϵͳ");
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
		//�û���������
		public static void raceEnroll() {
			Scanner input=new Scanner(System.in);
			//��ȡ�����б�
			System.out.println("��ѡ����Ҫѡ���������:");
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
				System.out.println("���²����ڣ������û���ҳ");
				userIndex();
			}
			else {
			//�������ĸ�����Ϣ
			System.out.println("�����������û���:");
			String username=input.nextLine();
			boolean isExist=false;
			for(User user:userList) {
				if(user.getUsername().equals(username)) {
					isExist=true;
					if(rc!=null) {
					rc.getUsersList().add(user);
					rc.setNumber(rc.getNumber()+1);
						System.out.println("�����ɹ�");
						}
					else {
						System.out.println("����ʧ��");
					}
				}
			}
			if(!isExist) {
				System.out.println("�û������ڣ�����ʧ��");
			}
			}
			System.out.println("�����û���ҳ");
			userIndex();
		}
		
		//�û������ɼ���ѯ
		public static void raceGrade() {
			Scanner input=new Scanner(System.in);
			System.out.println("��������Ҫ��ѯ�ı���:");
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
				System.out.println("���²����ڻ����˱���������");
			}
			else {
				System.out.println("����"+name+"���а�(ǰ10��)����:");
				int i=1;
			for(RaceGrade raceGrade3:datas) {
				if(i>10)
					break;
				System.out.println("��"+i+"��:"+raceGrade3.getUser().getUsername());
				i++;
			}
			}
			System.out.println("�����������û���:");
			String username=input.nextLine();
			boolean isUserExist=false;
			int i=1;
			System.out.println("����"+name);
			for(RaceGrade data:datas) {
				if(data.getUser().getUsername().equals(username)) {
					isUserExist=true;
					System.out.println("���ĳɼ�:"+data.getGrade()+"��������:"+i);
					i++;
					break;
				}
			}
			if(!isUserExist)
				System.out.println("δ���������»���û���������");
			System.out.println("��ѡ��1��������ѯ  2�������û���ҳ  3���˳�ϵͳ");
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
		
		//�û��鿴����
		public static void raceNotice() {
			Scanner input=new Scanner(System.in);
			System.out.println("������Ϊ��չʾ����ı���֪ͨ");
			int i=1;
			for(Notice notice:noticeList) {
				System.out.println("֪ͨ"+i+":");
				System.out.println("֪ͨ����:"+notice.getHeadline());
				System.out.println("֪ͨ����:"+notice.getContent());
				i++;
			}
			System.out.println("��ѡ��1�������鿴  2�������û���ҳ  3���˳�ϵͳ");
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
		
		//����Ա��ҳ
		public static void adminIndex() {
			Scanner input=new Scanner(System.in);
			System.out.println("��ӭ��������������Ϣ����ϵͳ�Ĺ���Ա����");
			System.out.println("��ѡ��:1���˻�����  2����������  3���ɼ�����  4��֪ͨ����  5��������ҳ  6���˳�ϵͳ");
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
		
		//�˻�����
		public static void userManage() {
			System.out.println("��ѡ�����²���:1����ѯ�˻�  2���˻�����  3����������  4�����ع���Ա��ҳ  5��������ҳ  6���˳�ϵͳ");
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
		
		//��ѯ�˻�
		public static void userSelect() {
			Scanner input=new Scanner(System.in);
			System.out.println("��������Ҫ��ѯ���û���:");
			String username=input.nextLine();
			boolean isSuccess=false;
			for(User user:userList) {
				if(user.getUsername().equals(username)) {
					isSuccess=true;
					System.out.println("��ѯ�ɹ�");
					System.out.println(user);
					break;
				}
			}
			if(!isSuccess)
			System.out.println("��ѯʧ�ܣ��޴��˺���Ϣ!");
			System.out.println("��ѡ��1��������ѯ  2�������˻�������ҳ  3���˳�ϵͳ");
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
		
		//�˻�����
		public static void userDisabled() {
			System.out.println("��������Ҫ���õ��˻�:");
			Scanner input=new Scanner(System.in);
			String username=input.nextLine();
			for(User user:userList) {
				if(user.getUsername().equals(username)) {
					System.out.println("�Ƿ�ȷ�Ͻ��ø��û���1��ȷ�ϣ�2��ȡ��");
					int x=input.nextInt();
					if(x==1) {
						user.setAvailable(false);
						System.out.println("���óɹ�!");
					}
					else {
						System.out.println("����ʧ��!");	
					}
				break;
				}
			}
			System.out.println("��ѡ��1����������  2�������˻�������ҳ  3���˳�ϵͳ");
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

		//��������
		public static void resetPassword() {
			System.out.println("��������Ҫ����������˺�:");
			Scanner input=new Scanner(System.in);
			String username=input.nextLine();
			boolean isSuccess=false;
			for(User user:userList) {
				if(user.getUsername().equals(username)) {
					isSuccess=true;
					System.out.println("ȷ���Ƿ��������룬1��ȷ�ϣ�2��ȡ��");
					int index=input.nextInt();
					if(index==1) {
						System.out.println("����������������ã�");
						String password=input.next();
						user.setPassword(password);
						System.out.println("���óɹ�");
					}
					else if(index==2) {
						System.out.println("ȡ������");
					}

				}
			}
			if(!isSuccess)
				System.out.println("��ѯʧ�ܣ��޴��˺���Ϣ��");
			System.out.println("��ѡ��1����������  2�������˻�������ҳ  3���˳�ϵͳ");
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
		
		//��������
		public static void raceManage() {
			Scanner input=new Scanner(System.in);
			System.out.println("��ѡ�����²���:1����ӱ���  2����ͣ����  3����ѯ�������  4�����ع���Ա��ҳ  5���˳�ϵͳ");
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
		
		//��ӱ���
		public static void insertRace() {
			Scanner input=new Scanner(System.in);
			System.out.println("�������������:");
			String name=input.nextLine();
			System.out.println("�������������:");
			String content=input.nextLine();
			System.out.println("�Ƿ������ӣ�1��ȷ����2��ȡ��");
			int index =input.nextInt();
			if(index==1) {
				Race race=new Race(name,content);
				raceList.add(race);
				System.out.println("��ӱ����ɹ�!");
			}
			System.out.println("��ѡ��1���������  2�����ر���������ҳ  3���˳�ϵͳ");
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
		
		//��ͣ����
		public static void handleRace() {
			Scanner input=new Scanner(System.in);
			System.out.println("��ѡ����Ҫ��ͣ�ı��������ƣ�");
			String name=input.nextLine();
			boolean isExist=false;
			for(Race race:raceList) {
				if(race.getName().equals(name)) {
					isExist=true;
					System.out.println("��ѡ��������ֹͣ������1��������2��ֹͣ:");
					int index=input.nextInt();
					if(index==1) {
						race.setAvailable(true);
						System.out.println("�����ɹ�!");
					}
					else if(index==2) {
						race.setAvailable(false);
						System.out.println("ֹͣ�ɹ�!");
					}
				}

			}
			if(!isExist) {
				System.out.println("���²�����!");
			}
			System.out.println("��ѡ��1��������ͣ  2�����ر���������ҳ  3���˳�ϵͳ");
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
		
		//��ѯ�������
		public static void selectRegister() {
			System.out.println("��������Ҫ��ѯ�ı���������");
			Scanner input=new Scanner(System.in);
			String name=input.nextLine();
			boolean isExist=false;
			for(Race race:raceList) {
				if(race.getName().equals(name)) {
					isExist=true;
					System.out.println("������"+race.getName()+"����Ա�������:");
					System.out.println("һ����������:"+race.getNumber());
					for(User user:race.getUsersList()) {
						System.out.println(user);
					}
				}

			}
			if(!isExist) {
				System.out.println("���²����ڣ�");
			}
			System.out.println("��ѡ��1��������ѯ  2�����ر���������ҳ  3���˳�ϵͳ");
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
		
		//�ɼ�����
		public static void gradeManage() {
			Scanner input=new Scanner(System.in);
			System.out.println("��ѡ�����²���:1��¼������ɼ�  2����ѯ�˶�Ա�ĳɼ�������  3����ѯ�������а�  4�����ع���Ա��ҳ  5���˳�ϵͳ");
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

		//¼��ɼ�
		public static void insertGrade() {
			Scanner input=new Scanner(System.in);
			System.out.println("�������������:");
			String name=input.nextLine();
			boolean isRaceExist=false;
			for(Race race:raceList) {
				if(race.getName().equals(name)) {
					isRaceExist=true;
					boolean isUserExist=false;
					System.out.println("�������û���:");
					String username=input.nextLine();
					for(User user:userList) {
						if(user.getUsername().equals(username)) {
							isUserExist=true;
							System.out.println("��������û��ĳɼ�:");
							double grade=input.nextDouble();
							RaceGrade raceGrade=new RaceGrade();
							raceGrade.setRace(race);
							raceGrade.setUser(user);
							raceGrade.setGrade(grade);
							raceGradeList.add(raceGrade);
							System.out.println("�ɼ�¼��ɹ�!");
							break;
						}	
					}
					if(!isUserExist)
						System.out.println("���û�������");
					break;
				}
			}
			if(!isRaceExist) {
				System.out.println("���²�����!");
			}
			System.out.println("��ѡ��1������¼��  2�����سɼ�������ҳ  3���˳�ϵͳ");
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

		//��ѯ�˶�Ա�ɼ�������
		public static void selectGrade() {
			List <RaceGrade> raceGrade = new ArrayList<RaceGrade>() ;
			Scanner input=new Scanner(System.in);
			System.out.println("���������µ�����:");
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
				System.out.println("���²����ڻ�����Ա����!");
			}
			else {
				boolean isUserExist=false;
				System.out.println("������Ҫ��ѯ���û���:");
				String username=input.nextLine();
				int i=1;
				for(RaceGrade raceGrade3:raceGrade) {
					if(raceGrade3.getUser().getUsername().equals(username)) {
						isUserExist=true;
						System.out.println("��ѯ�ɹ�");
						System.out.println("���û��ĳɼ���:"+raceGrade3.getGrade()+" ������:"+"��"+i+"��");
					}
					i++;
				}
				if(!isUserExist) {
					System.out.println("���û�������!");
				}
				System.out.println("��ѡ��1��������ѯ  2�����سɼ�������ҳ  3���˳�ϵͳ");
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
		//��ѯ������
		public static void selectRank() {
			List <RaceGrade> raceGrade = new ArrayList<RaceGrade>() ;
			Scanner input=new Scanner(System.in);
			System.out.println("��������Ҫ��ѯ������:");
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
				System.out.println("���²����ڻ�����Ա����!");
			}
			else {
				System.out.println("����"+name+"���а�����:");
				int i=1;
			for(RaceGrade raceGrade3:raceGrade) {
				System.out.println("��"+i+"��:"+raceGrade3.getUser().getUsername());
				i++;
			}
			}
			System.out.println("��ѡ��1��������ѯ  2�����سɼ�������ҳ  3���˳�ϵͳ");
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
		
		//֪ͨ����
		public static void noticeManage() {
			Scanner input=new Scanner(System.in);
			System.out.println("��ѡ�����²���:1�����֪ͨ  2������֪ͨ  3����ѯ֪ͨ  4��ɾ��֪ͨ  5�����ع���Ա��ҳ  6���˳�ϵͳ");
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
		
		//���֪ͨ
		public static void insertNotice() {
			Scanner input=new Scanner(System.in);
			System.out.println("������֪ͨ����:");
			String headline=input.nextLine();
			boolean isNoticeExist=false;
			for(Notice notice:noticeList) {
				if(notice.getHeadline().equals(headline)) {
					isNoticeExist=true;
					System.out.println("��֪ͨ�Ѵ���!���ʧ��");
					break;
				}
			}
			if(!isNoticeExist) {
				System.out.println("������֪ͨ����:");
				String content=input.nextLine();
			    Notice notice=new Notice();
			    notice.setHeadline(headline);
			    notice.setContent(content);
			    noticeList.add(notice);
			    System.out.println("���֪ͨ�ɹ�!");
			}
			System.out.println("��ѡ��1���������  2������֪ͨ������ҳ  3���˳�ϵͳ");
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

		//����֪ͨ
		public static void updateNotice() {
			Scanner input=new Scanner(System.in);
			System.out.println("������֪ͨ�ı���:");
			String headline=input.nextLine();
			boolean isNoticeExist=false;
			int i=0;
			for(Notice notice:noticeList) {
				if(notice.getHeadline().equals(headline)) {
					isNoticeExist=true;
					System.out.println("������Ҫ�޸ĵ�����:");
					String content=input.nextLine();
					noticeList.get(i).setContent(content);
					System.out.println("֪ͨ�޸ĳɹ�");
				}
				i++;
			}
			if(!isNoticeExist) {
				System.out.println("��֪ͨ�����ڣ�");
			}
			System.out.println("��ѡ��1����������  2������֪ͨ������ҳ  3���˳�ϵͳ");
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


		//��ѯ֪ͨ
		public static void selectNotice() {
			Scanner input=new Scanner(System.in);
			System.out.println("������֪ͨ�ı���:");
			String headline=input.nextLine();
			boolean isNoticeExist=false;
			for(Notice notice:noticeList) {
				if(notice.getHeadline().equals(headline)) {
					isNoticeExist=true;
					System.out.println("��ѯ�ɹ���");
					System.out.println("֪ͨ����:"+notice.getHeadline()+"֪ͨ����:"+notice.getContent());
					break;
				}
			}
			if(!isNoticeExist) {
				System.out.println("��֪ͨ�����ڣ�");
			}
			System.out.println("��ѡ��1��������ѯ  2������֪ͨ������ҳ  3���˳�ϵͳ");
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

		//ɾ������
		public static void deleteNotice() {
			Scanner input=new Scanner(System.in);
			System.out.println("������֪ͨ�ı��⣺");
			String headline=input.nextLine();
			boolean isNoticeExist=false;
			for(Notice notice:noticeList) {
				if(notice.getHeadline().equals(headline)) {
					isNoticeExist=true;
					System.out.println("��ȷ���Ƿ�ɾ����֪ͨ��1��ȷ�ϣ�2��ȡ��");
					int index=input.nextInt();
					if(index==1){
					noticeList.remove(notice);
					System.out.println("ɾ���ɹ���");
					}
					else if(index==2){
						System.out.println("ȡ��ɾ����");
					}
					break;
				}
			}
			if(!isNoticeExist) {
				System.out.println("��֪ͨ�����ڣ�");
			}
			System.out.println("��ѡ��1������ɾ��  2������֪ͨ������ҳ  3���˳�ϵͳ");
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
