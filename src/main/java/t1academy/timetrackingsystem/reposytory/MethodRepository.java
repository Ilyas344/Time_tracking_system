package t1academy.timetrackingsystem.reposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import t1academy.timetrackingsystem.model.Method;

import java.util.List;
import java.util.Optional;

@Repository
public interface MethodRepository extends JpaRepository<Method, Long> {

    List<Method> findMethods();

    Optional<Method> findByClassNameAndMethodName(String className, String methodName);

    Method findMethodByMethodName(@Param("methodName") String methodName);

    @Query("SELECT m.methodName FROM Method m")
    List<String> findAllMethodNames();

}
