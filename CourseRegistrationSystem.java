import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CourseReg
{
    String cTitle,cCode,cDescription,cSchedule;
    int cCapacity,avalSlots;

    public CourseReg(String title,String code,String description,String schedule,int capacity,int slots)
    {
        cTitle = title;
        cCode = code;
        cDescription = description;
        cSchedule = schedule;
        cCapacity = capacity;
        avalSlots = slots;
    }

    public void Listing()
    {
        System.out.println("Course Code: "+cCode+"\nTitle: "+cTitle+"\nDescription: "+cDescription+"\nCapacity: "+cCapacity+"\nSchedule: "+cSchedule+"\nAvailable slots: "+avalSlots);        
    }
}
class Student 
{
    String studentID,studentName;
    public List<CourseReg> registeredCourses = new ArrayList<>();

    public void registerForTheCourse(CourseReg course)
    {
        if(registeredCourses.contains(course)) 
            System.out.println("Already registered for this course");
        else 
        {
            course.avalSlots--;
            registeredCourses.add(course);
            System.out.println("You've successfully registered for the course-"+course.cTitle);
        }
    }
    public void dropFromTheCourse(CourseReg course)
    {
        course.avalSlots++;
        registeredCourses.remove(course);
        System.out.println("Successfully dropped from the course-"+course.cTitle);
    }
    public void showMyRegisteredCourses() 
    {
        if(registeredCourses.size()>0) 
        {
            System.out.println("\nHere are the list of Courses you've registered earlier--");
            for(CourseReg course:registeredCourses)
            {
                System.out.println("\n\n");
                course.Listing();
            }
        } 
        else 
            System.out.println("You haven't registered for any of the courses yet");
    }
}

public class CourseRegistrationSystem 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        List<CourseReg> availableCourses = new ArrayList<>();
        Student student = new Student();

        availableCourses.add(new CourseReg("Multivariable Calculus", "MATH301", "Dive into calculus with multiple variables. Study functions, limits, and derivatives in higher dimensions.", "Mondays and Wednesdays, 1:00 PM - 2:30 PM", 15, 5));
        availableCourses.add(new CourseReg("World History: 20th Century", "HIST202", "Explore the significant events and social changes that shaped the 20th century on a global scale.", "Tuesdays and Fridays, 10:00 AM - 11:30 AM", 8, 1));
        availableCourses.add(new CourseReg("Introduction to Physics", "PHYS101", "Delve into the basics of physics, covering mechanics, energy, and motion. No prior physics knowledge required.", "Thursdays, 9:00 AM - 12:00 PM", 25, 25));
        availableCourses.add(new CourseReg("Conversational Mandarin", "LANG401", "Learn practical Mandarin Chinese for daily conversations. Emphasis on speaking and listening skills.", "Wednesdays and Fridays, 4:00 PM - 5:30 PM", 12, 8));
        availableCourses.add(new CourseReg("Entrepreneurship Essentials", "BUSN202", "Uncover the key principles of starting and managing a successful business venture. Guest speakers and case studies included.", "Tuesdays, 2:00 PM - 4:00 PM", 20, 3));
                                
        System.out.println("\n\nStudent Registration--"+"\n");
        System.out.print("Enter Student Name:"); 
        student.studentName = sc.nextLine();
        System.out.print("Enter Student ID:"); 
        student.studentID = sc.nextLine();
        System.out.println("Student Registration Successful");

        int choice = 0;
        while(choice!=5) 
        {
        System.out.println("\nChoose an option:\n1.Register for a course\n2.Drop from a course\n3.Show available courses\n4.Show my registered courses\n5.Exit");
        while(true) 
        {
            System.out.print("Enter your choice here:");
            try 
            {
                choice = Integer.parseInt(sc.nextLine());
            } 
            catch(Exception e) 
            {
                System.out.println("Bad input! choose numericals only and in range of 1 to 5 given as options above.");
                continue;
            }
            if(!(choice>0 && choice<6))
            {
                System.out.println("Bad input! Enter numericals in range of 1 to 5 Only.");
            }
            else 
                break; 
        }
        if(choice==1) 
        {
            System.out.println("\n\nSelect a course based on the index to register for it-");
            for(int i=0;i<availableCourses.size();i++)
            {
                System.out.print((i+1)+".");
                availableCourses.get(i).Listing();
            }
            System.out.print("Enter here:");
            int choice2 = 0;
            try 
            {
                choice2 = Integer.parseInt(sc.nextLine());
            } 
            catch (Exception e) 
            {
                System.out.println("Bad input! choose numericals only and in range of indexes above");
                continue;
            }
            if(choice2>0 && choice2<=availableCourses.size())
            {
                student.registerForTheCourse(availableCourses.get(choice2-1));
            }
            else 
            {
                System.out.println("Bad input! You've choosen a course index that was unavailable.");
                continue;
            }
        } 
        else if(choice==2) 
        {
            if(student.registeredCourses.size()>0) 
            {
                System.out.println("\n\nHere are your Registrations. Select one based on the index to drop it from your registered courses:\n***************************************************************************************************\n");
                for(int i=0;i<student.registeredCourses.size();i++) 
                {
                System.out.print((i+1)+".");
                student.registeredCourses.get(i).Listing();
                }
                System.out.print("Enter here:");
                int choice2 = 0;
                try 
                {
                   choice2 = Integer.parseInt(sc.nextLine());
                }
                catch (Exception e) 
                {
                   System.out.println("Bad input! choose numericals only and in range of indexes above.");
                   continue;
                }
                if(choice2>0 && choice2<=student.registeredCourses.size())
                {
                   student.dropFromTheCourse(student.registeredCourses.get(choice2-1));
                }
                else 
                {
                   System.out.println("Bad input! You've choosen a course index that was unavailable.");
                   continue;
                }
            }
            else
            {
                System.out.println("You haven't registered for any courses yet.");
            }
        } 
        else if(choice==3) 
        {
            System.out.println("\n\nThese are the available courses for you to register:\n");
            for(CourseReg c : availableCourses) 
            { 
                c.Listing();
            }
        } 
        else if(choice==4) 
        {
            student.showMyRegisteredCourses();
        } 
        else if(choice==5)
        {
            System.out.println("Thanks for spending your time here! Be sure to attend classes if registered.");
        }
        }
    }
}