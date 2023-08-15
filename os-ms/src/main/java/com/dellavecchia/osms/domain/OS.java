package com.dellavecchia.osms.domain;

import com.dellavecchia.osms.domain.enums.Priority;
import com.dellavecchia.osms.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OS {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime openingDate;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime closingDate;
    private String comments;
    private Integer priority;
    private Integer status;
    @ManyToOne
    @JoinColumn(name = "technic_id")
    private Technic technic;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public OS() {
        super();
        this.setOpeningDate(LocalDateTime.now());
        this.setPriority(Priority.LOW);
        this.setStatus(Status.OPEN);

    }

    public OS(Integer id,
              String comments, Priority priority, Status status, Technic technic, Client client) {
        this.id = id;
        this.setOpeningDate(LocalDateTime.now());
        this.comments = comments;
        this.priority = (priority == null) ? 0 : priority.getCod();
        this.status = (status == null) ? 0 : status.getCod();
        this.technic = technic;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getOpeningDate() {
        return openingDate;
    }

    public LocalDateTime getClosingDate() {
        return closingDate;
    }

    public String getComments() {
        return comments;
    }

    public Priority getPriority() {
        return Priority.toEnum(this.priority);
    }

    public Status getStatus() {
        return Status.toEnum(this.status);
    }

    public Technic getTechnic() {
        return technic;
    }

    public Client getClient() {
        return client;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOpeningDate(LocalDateTime openingDate) {
        this.openingDate = openingDate;
    }

    public void setClosingDate(LocalDateTime closingDate) {
        this.closingDate = closingDate;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setPriority(Priority priority) {
        this.priority = priority.getCod();
    }

    public void setStatus(Status status) {
        this.status = status.getCod();
    }

    public void setTechnic(Technic technic) {
        this.technic = technic;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
