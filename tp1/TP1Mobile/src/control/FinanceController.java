package control;

import dao.impl.FinanceDAOImpl;
import model.Earning;
import model.Finance;
import model.Spending;
import util.FLogger;
import util.UUIDParser;

import java.util.UUID;
import java.util.Vector;

public class FinanceController {

    private String enviroment;
    private FinanceDAOImpl financeModel;
    private EarningController earning;
    private SpendingController spending;
    public FinanceController(String enviroment){
        this.enviroment = enviroment;
        this.financeModel = new FinanceDAOImpl(this.enviroment);
        this.earning = new EarningController(enviroment);
        this.spending = new SpendingController(enviroment);
    }

    public Vector<Finance> getAllFinances(){
        return financeModel.getAllFinances();
    }

    public void create(Finance finace){
        financeModel.createFinance(finace);
        if(finace.getValueEarn() == 0){
            spending.create(new Spending(UUIDParser.generateUUID(), finace.getUuid(),finace.getValueSpend()));
        }else{
            earning.create(new Earning(UUIDParser.generateUUID(), finace.getUuid(),finace.getValueEarn()));
        }
    }

    public void remove(UUID uuid){
        if(uuid != null){
            earning.remove(uuid);
            spending.remove(uuid);
            financeModel.removeFinance(uuid);
        }
    }
}
