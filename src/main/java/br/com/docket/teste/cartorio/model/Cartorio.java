package br.com.docket.teste.cartorio.model;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@Entity
@Generated
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Cartorio {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String nome;


}
