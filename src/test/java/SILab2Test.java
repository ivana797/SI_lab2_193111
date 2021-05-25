import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    private List<Time> createList(Time... elems){
        return new ArrayList<>(Arrays.asList(elems));
    }
    private List<Integer> rez(Integer... elem){
        return new ArrayList<>(Arrays.asList(elem));
    }

    @Test
    void multipleChoice(){

        RuntimeException exception;
        exception = assertThrows(RuntimeException.class, () ->SILab2.function(createList(new Time(-3,20,0))));
        assertTrue(exception.getMessage().contains("The hours are smaller than the minimum"));
        exception = assertThrows(RuntimeException.class, () ->SILab2.function(createList(new Time(28,23,30))));
        assertTrue(exception.getMessage().contains("The hours are grater than the maximum"));
        exception = assertThrows(RuntimeException.class, () ->SILab2.function(createList(new Time(20,-23,2))));
        assertTrue(exception.getMessage().contains("The minutes are not valid!"));

        exception = assertThrows(RuntimeException.class, () ->SILab2.function(createList(new Time(20,-2,5))));
        assertTrue(exception.getMessage().contains("The minutes are not valid!"));
        exception = assertThrows(RuntimeException.class, () ->SILab2.function(createList(new Time(15,65,5))));
        assertTrue(exception.getMessage().contains("The minutes are not valid!"));
        exception = assertThrows(RuntimeException.class, () ->SILab2.function(createList(new Time(10,50,-10))));
        assertTrue(exception.getMessage().contains("The seconds are not valid"));

        assertEquals(rez(55210), SILab2.function(createList(new Time(15,20,10))));

        exception = assertThrows(RuntimeException.class, () ->SILab2.function(createList(new Time(15,40,70))));
        assertTrue(exception.getMessage().contains("The seconds are not valid"));
        exception = assertThrows(RuntimeException.class, () ->SILab2.function(createList(new Time(15,30,-6))));
        assertTrue(exception.getMessage().contains("The seconds are not valid"));

        assertEquals(rez(86400), SILab2.function(createList(new Time(24,0,0))));
        exception = assertThrows(RuntimeException.class, () ->SILab2.function(createList(new Time(24,10,5))));
        assertTrue(exception.getMessage().contains("The time is greater than the maximum"));
        exception = assertThrows(RuntimeException.class, () ->SILab2.function(createList(new Time(24,12,5))));
        assertTrue(exception.getMessage().contains("The time is greater than the maximum"));
        exception = assertThrows(RuntimeException.class, () ->SILab2.function(createList(new Time(10,70,5))));
        assertTrue(exception.getMessage().contains("The minutes are not valid!"));
    }

    @Test
    void everyBranch(){
        RuntimeException exception;
        exception = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(-6,20,45))));
        assertTrue(exception.getMessage().contains("The hours are smaller than the minimum"));

        exception = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(28,34,56))));
        assertTrue(exception.getMessage().contains("The hours are grater than the maximum"));

        exception = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(12,80,8))));
        assertTrue(exception.getMessage().contains("The minutes are not valid!"));

        assertEquals(rez(67810), SILab2.function(createList(new Time(18,50,10))));

        exception = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(15,10,89))));
        assertTrue(exception.getMessage().contains("The seconds are not valid"));

        assertEquals(rez(86400), SILab2.function(createList(new Time(24,0,0))));

        exception = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(24,30,20))));
        assertTrue(exception.getMessage().contains("The time is greater than the maximum"));

    }
}