package t1academy.timetrackingsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "t_measurements")
@NoArgsConstructor
@Getter
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "measurement_id")
    private Long id;
    @Column(name = "execution_time")
    private Long executionTime;
    @Column(name = "date")
    private LocalDateTime date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "method_id")
    private Method method;


    public Measurement(Long executionTime, Method method) {
        this.executionTime = executionTime;
        this.date = LocalDateTime.now();
        this.method = method;
    }

}
