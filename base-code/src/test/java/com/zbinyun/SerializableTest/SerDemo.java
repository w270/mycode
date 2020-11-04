package com.zbinyun.SerializableTest;

import java.io.*;

public class SerDemo implements Serializable {
    public transient int age = 23;
    public String name ;
    public SerDemo(){
        System.out.println("默认构造器。。。");
    }
    public SerDemo(String name) {
        this.name = name;
    }
    private  void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(age);
    }
    private void readObject(ObjectInputStream stream) throws ClassNotFoundException, IOException {
        stream.defaultReadObject();
        age = stream.readInt();
    }

    public String toString() {
        return "年龄" + age + "  " + name;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerDemo stu = new SerDemo("Ming");
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bout);
        out.writeObject(stu);
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
        SerDemo stu1 = (SerDemo) in.readObject();
        System.out.println(stu1);
    }
}
