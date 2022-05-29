/**
 * CS304 (manually written) Issue link:  https://github.com/modelmapper/modelmapper/issues/639
 */
import org.junit.Test;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Jtest {
    @Test
    public void testAllNull() {
        ModelMapper mapper = new ModelMapper();
        MyObject obj = new MyObject("bar", List.of("a", "b", "c"));
        MyObject updates = new MyObject( null,null);
        // obj should be updated using the updates object. All null values should not be updated.

        System.out.println("------------------- TEST 1 -------------------");
        mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        mapper.map(updates,obj);
        assertEquals("MyObject{myStringProperty='bar', myListProperty=[a, b, c]}", obj.toString());
    }
    @Test
    public void testAllNotNull() {
        ModelMapper mapper = new ModelMapper();
        MyObject obj = new MyObject("bar", List.of("a", "b", "c"));
        MyObject updates = new MyObject( "candy", List.of("a", "b", "c","d"));
        // obj should be updated using the updates object. All null values should not be updated.

        System.out.println("------------------- TEST 1 -------------------");
        mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        mapper.map(updates,obj);
        assertEquals("MyObject{myStringProperty='candy', myListProperty=[a, b, c, d]}", obj.toString());
    }
    @Test
    public void testOnlyOneNull() {
        ModelMapper mapper = new ModelMapper();
        MyObject obj = new MyObject("bar", List.of("a", "b", "c"));
        MyObject updates = new MyObject( "candy", null);
        // obj should be updated using the updates object. 
        // All null values should not be updated.

        System.out.println("------------------- TEST 1 -------------------");
        mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        mapper.map(updates,obj);
        assertEquals("MyObject{myStringProperty='candy', myListProperty=[a, b, c]}", obj.toString());
    }
}
