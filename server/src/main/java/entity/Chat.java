package entity;

import javax.persistence.*;

@Entity
@Table(name = "Chat")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "data")
    private String data;

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", data='" + data + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId() {

        return id;
    }

    public String getData() {
        return data;
    }
}
