package com.crud.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.crud.model.mysql.User;

/*private long id;
private String firstName;
private String lastName;
private int age;
private String email;
private boolean active;
private LocalDate createdDate;*/

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	@Query(value = "from User u where u.id= :id")
	User getUserById(@Param(value = "id") int id);
	
	Optional<User> findById(long id);

	Optional<User> getByFirstName(String firstName);

	Optional<User> readByLastName(String lastName);

	long countByAge(int age);

	long countByCreatedDate(LocalDate createdDate);

	boolean existsByLastName(String lastName);

	void deleteByEmail(String email);

	void removeByEmail(String email);

	List<User> getByFirstNameAndLastName(String f, String l);

	List<User> findByAgeOrEmail(int age, String email);

	List<User> findByAgeBetween(int age1, int age2);

	List<User> findByEmailInAndAgeGreaterThanEqual(List<String> emails, int age);

	List<User> findByActiveTrue();

	List<User> findByActiveFalse();

	List<User> readByLastNameEndingWith(String s);

	List<User> getByFirstNameStartingWith(String s);

	List<User> findByAgeLessThanEqualOrderByFirstNameDesc(int age);

}
