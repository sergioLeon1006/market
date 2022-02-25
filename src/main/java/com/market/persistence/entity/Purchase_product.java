package com.market.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "compras_productos")
public class Purchase_product {
    @EmbeddedId
    private Purchase_productPK id;

    @Column(name = "cantidad")
    private Integer amount;

    private Double total;

    @Column(name = "estado")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "id_compra",insertable = false,updatable = false)
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "id_producto",insertable = false,updatable = false)
    private Product product ;
}
