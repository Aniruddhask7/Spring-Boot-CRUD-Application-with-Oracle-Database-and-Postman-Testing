
package in.strikes.crudProjectDemo.entity;

import jakarta.persistence.*;

@Entity
public class student {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_seq"
    )
    @SequenceGenerator(
            name = "student_seq",
            sequenceName = "STUDENT_SEQ",
            allocationSize = 1
    )

//    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String email;
    private int rollNo;
    private String subject;
    private boolean deleted;
//    private String phone_number;

    @Column(name = "phone_number", length = 15)
    private String phone_number;


    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public boolean isDeleted() {return deleted;}

    public void setDeleted(boolean deleted) {this.deleted = deleted;}
}
