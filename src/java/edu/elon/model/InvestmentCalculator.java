package edu.elon.model;

import java.io.Serializable;
import java.text.DecimalFormat;
/** 
 * Copyright (C) 2016 - James Greenwell
 * Elon University
 */
public class InvestmentCalculator implements Serializable{
  
  private double cash;
  private String formattedCash = "0";
  private double ratePercent;
  private int years;
  private String futureVal;
  private DecimalFormat df = new DecimalFormat("#.00");
  
  public InvestmentCalculator(){
    this.cash = 0;
    df = new DecimalFormat("#.00");
    df.setGroupingUsed(true);
    df.setGroupingSize(3);
    this.formattedCash = df.format(this.cash);
    this.ratePercent = 0;
    this.years=0;
    this.futureVal = "0";
  }
  
  public InvestmentCalculator(double cash, double ratePercent, int years){
    this.cash = cash;
    df = new DecimalFormat("#.00");
    df.setGroupingUsed(true);
    df.setGroupingSize(3);
    this.formattedCash = df.format(this.cash);
    this.ratePercent = ratePercent;
    this.years = years;
    this.futureVal = "0";
  }
  
  public double getCash(){
    return cash;
  }
  
  public void setCash(double cash){
    this.cash = cash;
  }
  
  public double getRatePercent(){
    return ratePercent;
  }
  
  public void setRatePercent(double ratePercent){
    this.ratePercent = ratePercent;
  }
  
  public int getYears(){
    return years;
  }
  
  public void setYears(int years){
    this.years = years;
  }
  
  public String getFutureVal(){
    return this.futureVal;
  }
  
  public void setFutureVal(String futureVal){
    this.futureVal = futureVal;
  }
  
  public String getFormattedCash(){
    return this.formattedCash;
  }
  
  public void setFormattedCash(String formattedCash){
    this.formattedCash = formattedCash;
  }
  
  public DecimalFormat getDf(){
    return this.df;
  }
  
  public void setDf(DecimalFormat df){
    this.df = df;
  }
  
  //Calculates the future monetary value of your investment
  public void calcFutureVal(){
    double cGrowth = cash;
    double rateOfGrowth = 1.0 + (ratePercent/100.0);
    for(int i = 0; i < years;i++){
      cGrowth = cGrowth*rateOfGrowth;
    }
    futureVal = df.format(cGrowth);
  }
}
