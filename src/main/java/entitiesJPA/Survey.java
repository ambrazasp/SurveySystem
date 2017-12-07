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
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "survey")
@NamedQueries({
    @NamedQuery(name = "Survey.findAll", query = "SELECT s FROM Survey s"),
    @NamedQuery(name = "Survey.findBySurveyID", query = "SELECT s FROM Survey s WHERE s.surveyID = :surveyID"),
    @NamedQuery(name = "Survey.findByDescription", query = "SELECT s FROM Survey s WHERE s.description = :description"),
    @NamedQuery(name = "Survey.findByStartDate", query = "SELECT s FROM Survey s WHERE s.startDate = :startDate"),
    @NamedQuery(name = "Survey.findByEndDate", query = "SELECT s FROM Survey s WHERE s.endDate = :endDate"),
    @NamedQuery(name = "Survey.findBySurveyURL", query = "SELECT s FROM Survey s WHERE s.surveyURL = :surveyURL"),
    @NamedQuery(name = "Survey.findByIsOpen", query = "SELECT s FROM Survey s WHERE s.isOpen = :isOpen"),
    @NamedQuery(name = "Survey.findByIsCreated", query = "SELECT s FROM Survey s WHERE s.isCreated = :isCreated"),
    @NamedQuery(name = "Survey.findByIsPrivate", query = "SELECT s FROM Survey s WHERE s.isPrivate = :isPrivate")})
@Getter
@Setter
@EqualsAndHashCode(of = "surveyID")
@ToString(of = "surveyID")
public class Survey implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SurveyID")
    private Long surveyID;
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @Column(name = "StartDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "EndDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "SurveyURL")
    private String surveyURL;
    @Basic(optional = false)
    @Column(name = "isOpen")
    private boolean isOpen;
    @Basic(optional = false)
    @Column(name = "isCreated")
    private boolean isCreated;
    @Basic(optional = false)
    @Column(name = "isPrivate")
    private boolean isPrivate;
    @JoinColumn(name = "PersonID", referencedColumnName = "PersonID")
    @ManyToOne(optional = false)
    private Person personID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "surveyID")
    private List<Question> questionList;
}
