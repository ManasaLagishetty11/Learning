package com.one2one;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Answer {

    @Id
    private int id;

    private String ans;

    @OneToOne(mappedBy = "answer")
    private Question q;

    public Answer() {
    }

    public Answer(int id, String ans) {
        this.id = id;
        this.ans = ans;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return ans;
    }

    public void setAnswer(String answer) {
        this.ans = answer;
    }
}
