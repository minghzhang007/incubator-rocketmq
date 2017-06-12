package org.apache.rocketmq.example.priorityqueue;

/**
 * Created by lewis0077 on 2017/6/12.
 */
public class Student {
    public Student(int id, String name, String hobby) {
        this.id = id;
        this.name = name;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    private int id;

    private String name;

    private String hobby;
}
