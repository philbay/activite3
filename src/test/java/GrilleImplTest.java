import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class GrilleImplTest {

@Test
public void testGetDimensoin(){
    GrilleImpl test = new GrilleImpl(4,4);
    assertEquals(1,test.getDimension());
}
@Test
public void testSetValue(){
    GrilleImpl test = new GrilleImpl(4,4);
    assertEquals(0, test.setValue(2,4,'6'));
}
@Test
public void testGetValue(){
    GrilleImpl test = new GrilleImpl(4,4);
    test.setValue(2,4,'6');
    assertEquals('6',test.getValue(2,4));
}
@Test
public void testComplete(){
    GrilleImpl test = new GrilleImpl(4,4);
    test.setValue(1,1,'1');
    test.setValue(1,2,'2');
    test.setValue(1,3,'3');
    test.setValue(1,4,'4');
    test.setValue(2,1,'5');
    test.setValue(2,2,'6');
    test.setValue(2,3,'7');
    test.setValue(2,4,'8');
    test.setValue(3,1,'9');
    test.setValue(3,2,'a');
    test.setValue(3,3,'b');
    test.setValue(3,4,'c');
    test.setValue(4,1,'d');
    test.setValue(4,2,'e');
    test.setValue(4,3,'f');
    test.setValue(4,4,'0');
    assertEquals(true, test.complete());
}
@Test
public void testPossible(){
    GrilleImpl test = new GrilleImpl(4,4);
    test.setValue(3,1,'6');
    assertEquals(true, test.possible(2,4,'6'));
}
/*@Test
public void testTableauPossible(){
    GrilleImpl test = new GrilleImpl(4,4);
    assertEquals(false, test.possibleContains('@'));
}*/
}