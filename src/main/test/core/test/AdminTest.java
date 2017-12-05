package core.test;

import core.api.IAdmin;
import core.api.IInstructor;
import core.api.IStudent;
import core.api.impl.Admin;
import core.api.impl.Instructor;
import core.api.impl.Student;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vincent on 23/2/2017.
 */
public class AdminTest {

    private IAdmin admin;
    private IInstructor instructor;
    private IStudent student;

    @Before
    public void setup() {
        this.admin = new Admin();
        this.instructor = new Instructor();
        this.student = new Student();
    }

    @Test
    public void testMakeClass() {
        this.admin.createClass("Test", 2017, "Instructor", 15);
        assertTrue(this.admin.classExists("Test", 2017));
    }

    @Test
    public void testMakeClass2() {
        this.admin.createClass("Test", 2016, "Instructor", 15);
        assertFalse(this.admin.classExists("Test", 2016));
    }
    
    @Test
    public void testMakeClass3() {
        this.admin.createClass("Test", 2017, "Instructor", 0);
        assertFalse(this.admin.classExists("Test", 2017));
    }
    
    @Test
    public void testMakeClass4() {
        this.admin.createClass("Testing", 2017, "Instructor", -1);
        assertFalse(this.admin.classExists("Test", 2017));
    }
    
    @Test
    public void testMakeClass5() {
        this.admin.createClass("Duplicate", 2017, "Bobby", 10);
        assertTrue(this.admin.classExists("Duplicate", 2017));
    }
    @Test
    public void testMakeClass6() {
        this.admin.createClass("Duplicate", 2017, "Bobby", 10);
        assertFalse(this.admin.classExists("Duplicate", 2017));
    }
}
