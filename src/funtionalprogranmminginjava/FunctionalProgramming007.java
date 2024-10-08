package funtionalprogranmminginjava;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
	
	private String name;
	private int noOfStudent;
	private int reviewScore;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNoOfStudent() {
		return noOfStudent;
	}
	public void setNoOfStudent(int noOfStudent) {
		this.noOfStudent = noOfStudent;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	
	
	public Course(String name, int noOfStudent, int reviewScore) {
		super();
		this.name = name;
		this.noOfStudent = noOfStudent;
		this.reviewScore = reviewScore;
	}
	@Override
	public String toString() {
		return "Course [name=" + name + ", noOfStudent=" + noOfStudent + ", reviewScore=" + reviewScore + "]";
	}
	
	
}
public class FunctionalProgramming007 {
	
	public static void main(String arg[]) {
		List<Course> courses = List.of(
				new Course("Java", 119371, 90),
				new Course("Spring Boot", 21143, 99),
				new Course("AWS", 1299, 94),
				new Course("GCP", 9312, 99),
				new Course("Azure", 8743, 96),
				new Course("Python", 40943, 90),
				new Course("Kafka", 4624, 90),
				new Course("Spark with Scala", 2375, 90),
				new Course("JavaScript", 99042, 56),
				new Course("React JS", 24391, 93),
				new Course("Angular", 7324, 94),
				new Course("Data Science", 49624, 94)
				);
		Predicate<Course> reviewScoreGreatherthan90 = a -> a.getReviewScore() > 90;
		System.out.println(courses.stream().allMatch(reviewScoreGreatherthan90));
		System.out.println("================================");
		System.out.println(courses.stream().anyMatch(reviewScoreGreatherthan90));
		System.out.println("================================");
		System.out.println(courses.stream().noneMatch(reviewScoreGreatherthan90));
		System.out.println("================================");
		List<Course> naturelOrderCompare = courses
				.stream()
				.collect(Collectors.toList());
		System.out.println("Natural order : " + naturelOrderCompare);
		System.out.println("================================");
		Comparator<Course> compareBasedOnReview = Comparator
				.comparing(Course::getReviewScore);
		List<Course> basedOnReview = courses.stream()
				.sorted(compareBasedOnReview)
				.collect(Collectors.toList());
		System.out.println("compareBasedOnReview order : " + basedOnReview);
		System.out.println("================================");
		Comparator<Course> compareBasedOnReviewThanNoOfStudent = Comparator
				.comparing(Course::getReviewScore)
				.thenComparing(Course::getNoOfStudent);
		List<Course> basedOnReviewThanStudent = courses.stream()
				.sorted(compareBasedOnReviewThanNoOfStudent)
				.collect(Collectors.toList());
		System.out.println("compareBasedOnReview order : " + basedOnReviewThanStudent);
		System.out.println("================================");
		Comparator<Course> compareBasedOnReviewThanNoOfStudentReverse = Comparator
				.comparing(Course::getReviewScore)
				.thenComparing(Course::getNoOfStudent)
				.reversed();
		List<Course> basedOnReviewThanStudentReverse = courses.stream()
				.sorted(compareBasedOnReviewThanNoOfStudentReverse)
				.collect(Collectors.toList());
		System.out.println("compareBasedOnReview order : " + basedOnReviewThanStudentReverse);
		System.out.println("================================");
		List<Course> top2Course = courses.stream()
				.sorted(compareBasedOnReviewThanNoOfStudent)
				.limit(2)
				.collect(Collectors.toList());
		System.out.println("top2Course : " + top2Course);
		System.out.println("================================");
		List<Course> skipTopCourses = courses.stream()
				.sorted(compareBasedOnReviewThanNoOfStudent)
				.skip(2)
				.collect(Collectors.toList());
		System.out.println("skipTopCourses : " + skipTopCourses);
		System.out.println("================================");
		List<Course> dropTopCoursesHaving90PlusReview = courses.stream()
				.sorted(compareBasedOnReviewThanNoOfStudent)
				.dropWhile(a -> a.getReviewScore() > 90)
				.collect(Collectors.toList());
		System.out.println("dropTopCoursesHaving90PlusReview : " + dropTopCoursesHaving90PlusReview);
		System.out.println("================================");
		List<Course> dropCoursesHavingLessReview = courses.stream()
				.sorted(compareBasedOnReviewThanNoOfStudent)
				.takeWhile(a -> a.getReviewScore() <=90)
				.collect(Collectors.toList());
		System.out.println("dropCoursesHavingLessReview : " + dropCoursesHavingLessReview);
		Optional<Course> minRecord = courses.stream().min(compareBasedOnReviewThanNoOfStudent);
		System.out.println("minRecord : " + minRecord);
		Comparator<Course> compareBasedOnReviewLessThan40 = Comparator
				.comparing(a -> a.getReviewScore() < 40);
		Optional<Course> minRecord40 = courses.stream()
				.filter(a-> a.getReviewScore() < 50)
				.min(compareBasedOnReviewLessThan40);
		System.out.println("minRecord40 : " + minRecord40);
		
		
	}
	
}
