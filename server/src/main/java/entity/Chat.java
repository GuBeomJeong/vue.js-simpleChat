package entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "chat")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "content")
    private String content;

    @Column(name = "date")
    private Date date;

    @Column(name = "nickname")
    private String nickname;

    public void setId(int id) {
        this.id = id;
    }


    public int getId() {

        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "{" +
                "content:'" + content + '\'' +
                ", date:" + date +
                ", nickname:'" + nickname + '\'' +
                '}';
    }
}
