/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitiesJPA;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "answer")
@NamedQueries({
    @NamedQuery(name = "Answer.findAll", query = "SELECT a FROM Answer a"),
    @NamedQuery(name = "Answer.findByAnswerID", query = "SELECT a FROM Answer a WHERE a.answerID = :answerID"),
    @NamedQuery(name = "Answer.findBySessionID", query = "SELECT a FROM Answer a WHERE a.sessionID = :sessionID"),
    @NamedQuery(name = "Answer.findByText", query = "SELECT a FROM Answer a WHERE a.text = :text")})
@Getter
@Setter
@EqualsAndHashCode(of = "answerID")
@ToString(of = "answerID")
public class Answer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AnswerID")
    private Long answerID;
    @Basic(optional = false)
    @Column(name = "SessionID")
    private int sessionID;
    @Column(name = "Text")
    private String text;
    @JoinColumn(name = "OfferedAnswerID", referencedColumnName = "OfferedAnswerID")
    @ManyToOne(optional = false)
    private Offeredanswer offeredAnswerID;
}
