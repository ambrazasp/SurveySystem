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
@Table(name = "answerconnection")
@NamedQueries({
    @NamedQuery(name = "Answerconnection.findAll", query = "SELECT a FROM Answerconnection a"),
    @NamedQuery(name = "Answerconnection.findByAnswerConnectionID", query = "SELECT a FROM Answerconnection a WHERE a.answerConnectionID = :answerConnectionID")})
@Getter
@Setter
@EqualsAndHashCode(of = "answerConnectionID")
@ToString(of = "answerConnectionID")
public class Answerconnection implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AnswerConnectionID")
    private Long answerConnectionID;
    @JoinColumn(name = "QuestionID", referencedColumnName = "QuestionID")
    @ManyToOne(optional = false)
    private Question questionID;
    @JoinColumn(name = "OfferedAnswerID", referencedColumnName = "OfferedAnswerID")
    @ManyToOne(optional = false)
    private Offeredanswer offeredAnswerID;
}
