package control;

import dao.impl.SpendingDAOImpl;
import model.Spending;

public class SpendingController {

    private String enviroment;
    private SpendingDAOImpl spendingModel;

    public SpendingController(String enviroment) {
        this.enviroment = enviroment;
        spendingModel = new SpendingDAOImpl(this.enviroment);

    }

    public String getTotalSpendings(){
        return Double.toString(spendingModel.getTotalSpendings());
    }

    public void create(Spending spending){
        spendingModel.createSpending(spending);
    }
}
