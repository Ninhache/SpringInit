package fr.neo.revisions.mvc.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "partie")  // Assurez-vous que la table existe en base
public class Partie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pno;         // identifiant de la partie

    private Long jno1;        // identifiant joueur 1
    private Long jno2;        // identifiant joueur 2
    private LocalDate date;   // date de la partie
    private Integer statut;   // 1=non commencée, 2=en cours, 3=terminée
    private Integer temps;    // temps global ?
    private Long gagnant;     // identifiant du gagnant (peut être null)

    public Partie() {
    }

    public Partie(Long jno1, Long jno2, LocalDate date, Integer statut, Integer temps, Long gagnant) {
        this.jno1 = jno1;
        this.jno2 = jno2;
        this.date = date;
        this.statut = statut;
        this.temps = temps;
        this.gagnant = gagnant;
    }

    public Long getPno() {
        return pno;
    }

    public void setPno(Long pno) {
        this.pno = pno;
    }

    public Long getJno1() {
        return jno1;
    }

    public void setJno1(Long jno1) {
        this.jno1 = jno1;
    }

    public Long getJno2() {
        return jno2;
    }

    public void setJno2(Long jno2) {
        this.jno2 = jno2;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getStatut() {
        return statut;
    }

    public void setStatut(Integer statut) {
        this.statut = statut;
    }

    public Integer getTemps() {
        return temps;
    }

    public void setTemps(Integer temps) {
        this.temps = temps;
    }

    public Long getGagnant() {
        return gagnant;
    }

    public void setGagnant(Long gagnant) {
        this.gagnant = gagnant;
    }
}
