package t1academy.timetrackingsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_methods")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Method {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "method_id")
    private Long id;
    @Column(name = "class_name")
    private String className;
    @Column(name = "method_name")
    private String methodName;
    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "method", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Measurement> measurements;

    public Method(String className, String methodName, List<Measurement> measurements) {
        this.className = className;
        this.methodName = methodName;
        this.measurements = measurements;
    }

    public Method(String className, String methodName) {
        this.className = className;
        this.methodName = methodName;
        this.measurements = new ArrayList<>();


    }
}
