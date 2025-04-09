package com.crud;

import java.sql.SQLDataException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crud.entity.Course;
import com.crud.entity.Student;
import com.crud.model.mysql.User;
import com.crud.repo.CourseRepo;
import com.crud.repo.StuRepo;
import com.crud.repo.UserRepo;
import com.crud.service.MessageService;
import com.crud.service.NotificationService;

@SpringBootApplication
@EnableScheduling
public class RestapiApplication implements CommandLineRunner {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private StuRepo stuRepo;
	
	@Autowired
	private CourseRepo courseRepo;

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(RestapiApplication.class, args);
		System.out.println("BeanDefinitionCount "+run.getBeanDefinitionCount());
		MessageService bean = run.getBean(MessageService.class);
		bean.sendMesaage();
		MessageService bean1 = run.getBean(MessageService.class);
		bean1.sendMesaage();
		MessageService bean3 = run.getBean(MessageService.class);
		bean3.sendMesaage();
		System.out.println(1000);
		
		
		

	}

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(100, "Tarak", "Konduri", 21, "tarak@gmail.com", true, LocalDate.now());
		User u2 = new User(101, "Vara", "Prasad", 26, "vara@gmail.com", true, LocalDate.now());
		User u3 = new User(103, "Naga", "Konduri", 27, "naga@gmail.com", true, LocalDate.now());
		User u4 = new User(104, "Tarak", "Konduri", 28, "tarak@gmail.com", true, LocalDate.now());
		User u5 = new User(105, "Python", "Script", 29, "python@gmail.com", true, LocalDate.now());
		User u6 = new User(106, "Javan", "Lang", 30, "javan@gmail.com", true, LocalDate.now());
		User u7 = new User(107, "Ashok", "It", 19, "ashok@gmail.com", true, LocalDate.now());
		User u8 = new User(108, "Prakash", "Rana", 25, "prakash@gmail.com", true, LocalDate.now());
		User u9 = new User(109, "Mani", "Kishore", 22, "mani@gmail.com", true, LocalDate.now());
		User u10 = new User(110, "Raja", "Kumar", 20, "raja@gmail.com", false, LocalDate.now());
		//userRepo.deleteAll();
		//userRepo.saveAll(Arrays.asList(u1, u2, u3, u4, u5, u6, u7, u8, u9, u10));
		//System.err.println("All users are saved...");
		//test();
		
		Course math = new Course();
		Course telugu = new Course();
		math.setName("Science");
		telugu.setName("Hindi");
		
		Student s = new Student();
		s.setName("Siva Rama");
		s.getCourses().add(telugu);
		s.getCourses().add(math);
		math.getStudents().add(s);
		telugu.getStudents().add(s);
		//courseRepo.saveAll(List.of(math,telugu));
	//	stuRepo.save(s);
		
	//	System.out.println(stuRepo.findById(252l));
		//stuRepo.deleteById(302l);
		//stuRepo.deleteAll();
		//List<Course> all = courseRepo.findAll();
		//all.forEach(a->System.out.println(a));

	}

	// @Transactional
	public void test() {

		Optional<User> byId = userRepo.findById(100);
		System.out.println("findById() " + byId);

		Optional<User> byFirstName = userRepo.getByFirstName("Vara");
		System.out.println(byFirstName);
		Optional<User> byLastName = userRepo.readByLastName("Raja");
		System.out.println(byLastName);
		long countByAge = userRepo.countByAge(25);
		System.out.println(countByAge);
		long countByCreatedDate = userRepo.countByCreatedDate(LocalDate.now());
		System.out.println(countByCreatedDate);
		boolean existsByLastName = userRepo.existsByLastName("Kishore");
		System.out.println(existsByLastName);
		// userRepo.deleteById(110l);
		// userRepo.removeByEmail("raja@gmail.com");
		// userRepo.deleteByEmail("mani@gmail.com");
		List<User> byAgeBetween = userRepo.findByAgeBetween(20, 22);
		System.out.println(byAgeBetween);
		List<User> byEmailInAndAgeGreaterThanEqual = userRepo.findByEmailInAndAgeGreaterThanEqual(
				List.of("mani@gmail.com", "tarak@gmail.com", "javan@gmail.com"), 25);
		System.out.println(byEmailInAndAgeGreaterThanEqual);

		List<User> byActiveTrue = userRepo.findByActiveTrue();
		System.out.println(byActiveTrue);

		List<User> byActiveFalse2 = userRepo.findByActiveFalse();
		System.out.println(byActiveFalse2);

		List<User> byLastNameEndingWith = userRepo.readByLastNameEndingWith("ri");
		System.out.println(byLastNameEndingWith);

		List<User> byFirstNameStartingWith = userRepo.getByFirstNameStartingWith("Ta");
		System.out.println(byFirstNameStartingWith);

		List<User> byAgeLessThanEqualOrderByDesc = userRepo.findByAgeLessThanEqualOrderByFirstNameDesc(23);
		System.out.println(byAgeLessThanEqualOrderByDesc);

		User userById = userRepo.getUserById(100);
		System.err.println(userById);
	}
	
	
	// On the 1st and 15th of every month at 10:00 AM:
//	@Scheduled(cron = "0 0 10 1,15 * ?")
	// Last day of the month at midnight:
//	@Scheduled(cron = "0 0 0 28,30,31 * ?")
	// Every Monday at 9:00 AM:
//	@Scheduled(cron = "0 0 9 * * MON")
	// Every day at 2:30 AM:
//	@Scheduled(cron = "0/3 * * * * *")
	public void scheduled() {
		
		try {
			//System.out.println("before wait");
			Thread.sleep(5000);
			System.out.println("after wait");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW,
			       isolation = Isolation.READ_COMMITTED,
			       readOnly = true,
			       rollbackFor = {RuntimeException.class},
			       noRollbackFor = {SQLDataException.class},
			       timeout = 30
			
			)
	public void name() {
		
	}

}
