package at.alwinschuster;
/**
 * CS304 (manually written) Issue link:  https://github.com/modelmapper/modelmapper/issues/639
 */
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        test1();
        test2();
        System.out.println("------------------- END    -------------------");
    }

    /**
     * Map one non-null attributes of updates to obj
     * The source code was wrong because the condition object backwards
     * isNotNull() is the condition of updates not obj
     */
    private static void test1(){
        ModelMapper mapper = new ModelMapper();
        MyObject obj = new MyObject("bar", List.of("a", "b", "c"));
        MyObject updates = new MyObject( null,List.of("a", "b", "c", "d"));
        // obj should be updated using the updates object. All null values should not be updated.

        System.out.println("------------------- TEST 1 -------------------");
        mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        mapper.map(updates,obj);
        System.out.println(obj);
        System.out.println("SUCCEED -- Excepted:  MyObject{myStringProperty='bar', myListProperty=[a, b, c, d]}");
    }
    /**
     * Map one non-null attributes of updates to obj
     * The source code was wrong because the condition object backwards
     * isNotNull() is the condition of updates not obj
     */
    private static void test2(){
        ModelMapper mapper = new ModelMapper();
        var obj = new MyObject("bar", List.of("a", "b", "c"));
        var updates = new MyObject(null, List.of("a", "b", "c", "d"));

        // obj should be updated using the updates object. All null values should not be updated.

        System.out.println("------------------- TEST 2 -------------------");
        // ctx.getDestination() -> Always null, expected List.of("a", "b", "c")
        mapper.getConfiguration().setPropertyCondition(ctx -> {
            System.out.println("Destination: " + ctx.getDestination());
            return ctx.getDestination() != null;
        });
        mapper.map(updates,obj );
        System.out.println(obj);
        System.out.println("SUCCEED -- Excepted:  MyObject{myStringProperty='bar', myListProperty=[a, b, c, d]}");
    }
}
