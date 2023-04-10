package ru.tupi.lunchvoting.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class NamedEntity extends BaseEntity {

    protected static final int STRING_MIN_SIZE = 2;
    protected static final int STRING_MAX_SIZE = 128;

    @NotBlank
    @Size(min = STRING_MIN_SIZE, max = STRING_MAX_SIZE)
    @Column(name = "name", nullable = false)
//    @NoHtml
    protected String name;

    protected NamedEntity(Integer id, String name) {
        super(id);
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() + '[' + name + ']';
    }
}