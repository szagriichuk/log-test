package com.playtika.log;

import java.util.Arrays;
import java.util.List;

/**
 * @author szagriichuk
 */
public class TestBean {
    public String name;
    public int id;
    public String[] data;
    public List<String> someOtherData;

    public TestBean(String name, int id, String[] data, List<String> someOtherData) {
        this.name = name;
        this.id = id;
        this.data = data;
        this.someOtherData = someOtherData;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", data=" + Arrays.toString(data) +
                ", someOtherData=" + someOtherData +
                '}';
    }
}
