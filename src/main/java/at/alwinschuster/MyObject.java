package at.alwinschuster;

import java.util.List;

public class MyObject {
    private String myStringProperty;
    private List<String> myListProperty;

    public MyObject(String myStringProperty, List<String> myListProperty) {
        this.myStringProperty = myStringProperty;
        this.myListProperty = myListProperty;
    }

    public String getMyStringProperty() {
        return myStringProperty;
    }

    public void setMyStringProperty(String myStringProperty) {
        this.myStringProperty = myStringProperty;
    }

    public List<String> getMyListProperty() {
        return myListProperty;
    }

    public void setMyListProperty(List<String> myListProperty) {
        this.myListProperty = myListProperty;
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "myStringProperty='" + myStringProperty + '\'' +
                ", myListProperty=" + myListProperty +
                '}';
    }
}
