

public class RaceGrade implements Comparable<RaceGrade>{
	private Race race;
	private User user;
	private double grade;
	private int rank;
	public Race getRace() {
		return race;
	}
	public void setRace(Race race) {
		this.race = race;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
			this.rank = rank;
	}

	public int compareTo(RaceGrade o) {
		return (int) (o.getGrade()-this.grade);
	}
}

