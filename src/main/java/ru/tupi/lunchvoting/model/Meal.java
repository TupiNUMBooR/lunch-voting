package ru.tupi.lunchvoting.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.LocalDate;

@Entity
@Table(name = "meal")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Meal extends AbstractPersistable<Integer> {
    @Column
    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurant restaurant;

    @Column
    private LocalDate day;

    @Column
    @Size(max = 128)
    private String name;

    @Column
    private int price;
}
