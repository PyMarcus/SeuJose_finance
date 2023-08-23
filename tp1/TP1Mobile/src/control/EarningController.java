package control;

import dao.impl.EarningDAOImpl;
import model.Earning;

import java.util.UUID;

public class EarningController {
    private String enviroment;
    private EarningDAOImpl earningModel;

    public EarningController(String enviroment) {
        this.enviroment = enviroment;
        earningModel = new EarningDAOImpl(this.enviroment);

    }

    public String getTotalEarning(){
        return Double.toString(earningModel.getTotalEarnings());
    }

    public void create(Earning earning){
        earningModel.createEarning(earning);
    }

    public void remove(UUID uuid){
        earningModel.removeEarning(uuid);
    }
}
