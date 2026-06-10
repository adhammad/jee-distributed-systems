package repositories;

import org.springframework.stereotype.Repository;

@Repository("dao")
public class IDaoRepositoryImpl implements IDaoRepository {

    @Override
    public double getData() {
        System.out.println("get Data V1");
        return 12;
    }
}
