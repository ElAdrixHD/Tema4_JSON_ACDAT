package adrianmmudarra.es.tema4_json_acdat.model.conversor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;

public class Monedas {

    @SerializedName("AED")
    @Expose
    private String aED;
    @SerializedName("AFN")
    @Expose
    private String aFN;
    @SerializedName("ALL")
    @Expose
    private String aLL;
    @SerializedName("AMD")
    @Expose
    private String aMD;
    @SerializedName("ANG")
    @Expose
    private String aNG;
    @SerializedName("AOA")
    @Expose
    private String aOA;
    @SerializedName("ARS")
    @Expose
    private String aRS;
    @SerializedName("AUD")
    @Expose
    private String aUD;
    @SerializedName("AWG")
    @Expose
    private String aWG;
    @SerializedName("AZN")
    @Expose
    private String aZN;
    @SerializedName("BAM")
    @Expose
    private String bAM;
    @SerializedName("BBD")
    @Expose
    private String bBD;
    @SerializedName("BDT")
    @Expose
    private String bDT;
    @SerializedName("BGN")
    @Expose
    private String bGN;
    @SerializedName("BHD")
    @Expose
    private String bHD;
    @SerializedName("BIF")
    @Expose
    private String bIF;
    @SerializedName("BMD")
    @Expose
    private String bMD;
    @SerializedName("BND")
    @Expose
    private String bND;
    @SerializedName("BOB")
    @Expose
    private String bOB;
    @SerializedName("BRL")
    @Expose
    private String bRL;
    @SerializedName("BSD")
    @Expose
    private String bSD;
    @SerializedName("BTC")
    @Expose
    private String bTC;
    @SerializedName("BTN")
    @Expose
    private String bTN;
    @SerializedName("BWP")
    @Expose
    private String bWP;
    @SerializedName("BYN")
    @Expose
    private String bYN;
    @SerializedName("BZD")
    @Expose
    private String bZD;
    @SerializedName("CAD")
    @Expose
    private String cAD;
    @SerializedName("CDF")
    @Expose
    private String cDF;
    @SerializedName("CHF")
    @Expose
    private String cHF;
    @SerializedName("CLF")
    @Expose
    private String cLF;
    @SerializedName("CLP")
    @Expose
    private String cLP;
    @SerializedName("CNH")
    @Expose
    private String cNH;
    @SerializedName("CNY")
    @Expose
    private String cNY;
    @SerializedName("COP")
    @Expose
    private String cOP;
    @SerializedName("CRC")
    @Expose
    private String cRC;
    @SerializedName("CUC")
    @Expose
    private String cUC;
    @SerializedName("CUP")
    @Expose
    private String cUP;
    @SerializedName("CVE")
    @Expose
    private String cVE;
    @SerializedName("CZK")
    @Expose
    private String cZK;
    @SerializedName("DJF")
    @Expose
    private String dJF;
    @SerializedName("DKK")
    @Expose
    private String dKK;
    @SerializedName("DOP")
    @Expose
    private String dOP;
    @SerializedName("DZD")
    @Expose
    private String dZD;
    @SerializedName("EGP")
    @Expose
    private String eGP;
    @SerializedName("ERN")
    @Expose
    private String eRN;
    @SerializedName("ETB")
    @Expose
    private String eTB;
    @SerializedName("EUR")
    @Expose
    private String eUR;
    @SerializedName("FJD")
    @Expose
    private String fJD;
    @SerializedName("FKP")
    @Expose
    private String fKP;
    @SerializedName("GBP")
    @Expose
    private String gBP;
    @SerializedName("GEL")
    @Expose
    private String gEL;
    @SerializedName("GGP")
    @Expose
    private String gGP;
    @SerializedName("GHS")
    @Expose
    private String gHS;
    @SerializedName("GIP")
    @Expose
    private String gIP;
    @SerializedName("GMD")
    @Expose
    private String gMD;
    @SerializedName("GNF")
    @Expose
    private String gNF;
    @SerializedName("GTQ")
    @Expose
    private String gTQ;
    @SerializedName("GYD")
    @Expose
    private String gYD;
    @SerializedName("HKD")
    @Expose
    private String hKD;
    @SerializedName("HNL")
    @Expose
    private String hNL;
    @SerializedName("HRK")
    @Expose
    private String hRK;
    @SerializedName("HTG")
    @Expose
    private String hTG;
    @SerializedName("HUF")
    @Expose
    private String hUF;
    @SerializedName("IDR")
    @Expose
    private String iDR;
    @SerializedName("ILS")
    @Expose
    private String iLS;
    @SerializedName("IMP")
    @Expose
    private String iMP;
    @SerializedName("INR")
    @Expose
    private String iNR;
    @SerializedName("IQD")
    @Expose
    private String iQD;
    @SerializedName("IRR")
    @Expose
    private String iRR;
    @SerializedName("ISK")
    @Expose
    private String iSK;
    @SerializedName("JEP")
    @Expose
    private String jEP;
    @SerializedName("JMD")
    @Expose
    private String jMD;
    @SerializedName("JOD")
    @Expose
    private String jOD;
    @SerializedName("JPY")
    @Expose
    private String jPY;
    @SerializedName("KES")
    @Expose
    private String kES;
    @SerializedName("KGS")
    @Expose
    private String kGS;
    @SerializedName("KHR")
    @Expose
    private String kHR;
    @SerializedName("KMF")
    @Expose
    private String kMF;
    @SerializedName("KPW")
    @Expose
    private String kPW;
    @SerializedName("KRW")
    @Expose
    private String kRW;
    @SerializedName("KWD")
    @Expose
    private String kWD;
    @SerializedName("KYD")
    @Expose
    private String kYD;
    @SerializedName("KZT")
    @Expose
    private String kZT;
    @SerializedName("LAK")
    @Expose
    private String lAK;
    @SerializedName("LBP")
    @Expose
    private String lBP;
    @SerializedName("LKR")
    @Expose
    private String lKR;
    @SerializedName("LRD")
    @Expose
    private String lRD;
    @SerializedName("LSL")
    @Expose
    private String lSL;
    @SerializedName("LYD")
    @Expose
    private String lYD;
    @SerializedName("MAD")
    @Expose
    private String mAD;
    @SerializedName("MDL")
    @Expose
    private String mDL;
    @SerializedName("MGA")
    @Expose
    private String mGA;
    @SerializedName("MKD")
    @Expose
    private String mKD;
    @SerializedName("MMK")
    @Expose
    private String mMK;
    @SerializedName("MNT")
    @Expose
    private String mNT;
    @SerializedName("MOP")
    @Expose
    private String mOP;
    @SerializedName("MRO")
    @Expose
    private String mRO;
    @SerializedName("MRU")
    @Expose
    private String mRU;
    @SerializedName("MUR")
    @Expose
    private String mUR;
    @SerializedName("MVR")
    @Expose
    private String mVR;
    @SerializedName("MWK")
    @Expose
    private String mWK;
    @SerializedName("MXN")
    @Expose
    private String mXN;
    @SerializedName("MYR")
    @Expose
    private String mYR;
    @SerializedName("MZN")
    @Expose
    private String mZN;
    @SerializedName("NAD")
    @Expose
    private String nAD;
    @SerializedName("NGN")
    @Expose
    private String nGN;
    @SerializedName("NIO")
    @Expose
    private String nIO;
    @SerializedName("NOK")
    @Expose
    private String nOK;
    @SerializedName("NPR")
    @Expose
    private String nPR;
    @SerializedName("NZD")
    @Expose
    private String nZD;
    @SerializedName("OMR")
    @Expose
    private String oMR;
    @SerializedName("PAB")
    @Expose
    private String pAB;
    @SerializedName("PEN")
    @Expose
    private String pEN;
    @SerializedName("PGK")
    @Expose
    private String pGK;
    @SerializedName("PHP")
    @Expose
    private String pHP;
    @SerializedName("PKR")
    @Expose
    private String pKR;
    @SerializedName("PLN")
    @Expose
    private String pLN;
    @SerializedName("PYG")
    @Expose
    private String pYG;
    @SerializedName("QAR")
    @Expose
    private String qAR;
    @SerializedName("RON")
    @Expose
    private String rON;
    @SerializedName("RSD")
    @Expose
    private String rSD;
    @SerializedName("RUB")
    @Expose
    private String rUB;
    @SerializedName("RWF")
    @Expose
    private String rWF;
    @SerializedName("SAR")
    @Expose
    private String sAR;
    @SerializedName("SBD")
    @Expose
    private String sBD;
    @SerializedName("SCR")
    @Expose
    private String sCR;
    @SerializedName("SDG")
    @Expose
    private String sDG;
    @SerializedName("SEK")
    @Expose
    private String sEK;
    @SerializedName("SGD")
    @Expose
    private String sGD;
    @SerializedName("SHP")
    @Expose
    private String sHP;
    @SerializedName("SLL")
    @Expose
    private String sLL;
    @SerializedName("SOS")
    @Expose
    private String sOS;
    @SerializedName("SRD")
    @Expose
    private String sRD;
    @SerializedName("SSP")
    @Expose
    private String sSP;
    @SerializedName("STD")
    @Expose
    private String sTD;
    @SerializedName("STN")
    @Expose
    private String sTN;
    @SerializedName("SVC")
    @Expose
    private String sVC;
    @SerializedName("SYP")
    @Expose
    private String sYP;
    @SerializedName("SZL")
    @Expose
    private String sZL;
    @SerializedName("THB")
    @Expose
    private String tHB;
    @SerializedName("TJS")
    @Expose
    private String tJS;
    @SerializedName("TMT")
    @Expose
    private String tMT;
    @SerializedName("TND")
    @Expose
    private String tND;
    @SerializedName("TOP")
    @Expose
    private String tOP;
    @SerializedName("TRY")
    @Expose
    private String tRY;
    @SerializedName("TTD")
    @Expose
    private String tTD;
    @SerializedName("TWD")
    @Expose
    private String tWD;
    @SerializedName("TZS")
    @Expose
    private String tZS;
    @SerializedName("UAH")
    @Expose
    private String uAH;
    @SerializedName("UGX")
    @Expose
    private String uGX;
    @SerializedName("USD")
    @Expose
    private String uSD;
    @SerializedName("UYU")
    @Expose
    private String uYU;
    @SerializedName("UZS")
    @Expose
    private String uZS;
    @SerializedName("VEF")
    @Expose
    private String vEF;
    @SerializedName("VES")
    @Expose
    private String vES;
    @SerializedName("VND")
    @Expose
    private String vND;
    @SerializedName("VUV")
    @Expose
    private String vUV;
    @SerializedName("WST")
    @Expose
    private String wST;
    @SerializedName("XAF")
    @Expose
    private String xAF;
    @SerializedName("XAG")
    @Expose
    private String xAG;
    @SerializedName("XAU")
    @Expose
    private String xAU;
    @SerializedName("XCD")
    @Expose
    private String xCD;
    @SerializedName("XDR")
    @Expose
    private String xDR;
    @SerializedName("XOF")
    @Expose
    private String xOF;
    @SerializedName("XPD")
    @Expose
    private String xPD;
    @SerializedName("XPF")
    @Expose
    private String xPF;
    @SerializedName("XPT")
    @Expose
    private String xPT;
    @SerializedName("YER")
    @Expose
    private String yER;
    @SerializedName("ZAR")
    @Expose
    private String zAR;
    @SerializedName("ZMW")
    @Expose
    private String zMW;
    @SerializedName("ZWL")
    @Expose
    private String zWL;

    public String getAED() {
        return aED;
    }

    public void setAED(String aED) {
        this.aED = aED;
    }

    public String getAFN() {
        return aFN;
    }

    public void setAFN(String aFN) {
        this.aFN = aFN;
    }

    public String getALL() {
        return aLL;
    }

    public void setALL(String aLL) {
        this.aLL = aLL;
    }

    public String getAMD() {
        return aMD;
    }

    public void setAMD(String aMD) {
        this.aMD = aMD;
    }

    public String getANG() {
        return aNG;
    }

    public void setANG(String aNG) {
        this.aNG = aNG;
    }

    public String getAOA() {
        return aOA;
    }

    public void setAOA(String aOA) {
        this.aOA = aOA;
    }

    public String getARS() {
        return aRS;
    }

    public void setARS(String aRS) {
        this.aRS = aRS;
    }

    public String getAUD() {
        return aUD;
    }

    public void setAUD(String aUD) {
        this.aUD = aUD;
    }

    public String getAWG() {
        return aWG;
    }

    public void setAWG(String aWG) {
        this.aWG = aWG;
    }

    public String getAZN() {
        return aZN;
    }

    public void setAZN(String aZN) {
        this.aZN = aZN;
    }

    public String getBAM() {
        return bAM;
    }

    public void setBAM(String bAM) {
        this.bAM = bAM;
    }

    public String getBBD() {
        return bBD;
    }

    public void setBBD(String bBD) {
        this.bBD = bBD;
    }

    public String getBDT() {
        return bDT;
    }

    public void setBDT(String bDT) {
        this.bDT = bDT;
    }

    public String getBGN() {
        return bGN;
    }

    public void setBGN(String bGN) {
        this.bGN = bGN;
    }

    public String getBHD() {
        return bHD;
    }

    public void setBHD(String bHD) {
        this.bHD = bHD;
    }

    public String getBIF() {
        return bIF;
    }

    public void setBIF(String bIF) {
        this.bIF = bIF;
    }

    public String getBMD() {
        return bMD;
    }

    public void setBMD(String bMD) {
        this.bMD = bMD;
    }

    public String getBND() {
        return bND;
    }

    public void setBND(String bND) {
        this.bND = bND;
    }

    public String getBOB() {
        return bOB;
    }

    public void setBOB(String bOB) {
        this.bOB = bOB;
    }

    public String getBRL() {
        return bRL;
    }

    public void setBRL(String bRL) {
        this.bRL = bRL;
    }

    public String getBSD() {
        return bSD;
    }

    public void setBSD(String bSD) {
        this.bSD = bSD;
    }

    public String getBTC() {
        return bTC;
    }

    public void setBTC(String bTC) {
        this.bTC = bTC;
    }

    public String getBTN() {
        return bTN;
    }

    public void setBTN(String bTN) {
        this.bTN = bTN;
    }

    public String getBWP() {
        return bWP;
    }

    public void setBWP(String bWP) {
        this.bWP = bWP;
    }

    public String getBYN() {
        return bYN;
    }

    public void setBYN(String bYN) {
        this.bYN = bYN;
    }

    public String getBZD() {
        return bZD;
    }

    public void setBZD(String bZD) {
        this.bZD = bZD;
    }

    public String getCAD() {
        return cAD;
    }

    public void setCAD(String cAD) {
        this.cAD = cAD;
    }

    public String getCDF() {
        return cDF;
    }

    public void setCDF(String cDF) {
        this.cDF = cDF;
    }

    public String getCHF() {
        return cHF;
    }

    public void setCHF(String cHF) {
        this.cHF = cHF;
    }

    public String getCLF() {
        return cLF;
    }

    public void setCLF(String cLF) {
        this.cLF = cLF;
    }

    public String getCLP() {
        return cLP;
    }

    public void setCLP(String cLP) {
        this.cLP = cLP;
    }

    public String getCNH() {
        return cNH;
    }

    public void setCNH(String cNH) {
        this.cNH = cNH;
    }

    public String getCNY() {
        return cNY;
    }

    public void setCNY(String cNY) {
        this.cNY = cNY;
    }

    public String getCOP() {
        return cOP;
    }

    public void setCOP(String cOP) {
        this.cOP = cOP;
    }

    public String getCRC() {
        return cRC;
    }

    public void setCRC(String cRC) {
        this.cRC = cRC;
    }

    public String getCUC() {
        return cUC;
    }

    public void setCUC(String cUC) {
        this.cUC = cUC;
    }

    public String getCUP() {
        return cUP;
    }

    public void setCUP(String cUP) {
        this.cUP = cUP;
    }

    public String getCVE() {
        return cVE;
    }

    public void setCVE(String cVE) {
        this.cVE = cVE;
    }

    public String getCZK() {
        return cZK;
    }

    public void setCZK(String cZK) {
        this.cZK = cZK;
    }

    public String getDJF() {
        return dJF;
    }

    public void setDJF(String dJF) {
        this.dJF = dJF;
    }

    public String getDKK() {
        return dKK;
    }

    public void setDKK(String dKK) {
        this.dKK = dKK;
    }

    public String getDOP() {
        return dOP;
    }

    public void setDOP(String dOP) {
        this.dOP = dOP;
    }

    public String getDZD() {
        return dZD;
    }

    public void setDZD(String dZD) {
        this.dZD = dZD;
    }

    public String getEGP() {
        return eGP;
    }

    public void setEGP(String eGP) {
        this.eGP = eGP;
    }

    public String getERN() {
        return eRN;
    }

    public void setERN(String eRN) {
        this.eRN = eRN;
    }

    public String getETB() {
        return eTB;
    }

    public void setETB(String eTB) {
        this.eTB = eTB;
    }

    public String getEUR() {
        return eUR;
    }

    public void setEUR(String eUR) {
        this.eUR = eUR;
    }

    public String getFJD() {
        return fJD;
    }

    public void setFJD(String fJD) {
        this.fJD = fJD;
    }

    public String getFKP() {
        return fKP;
    }

    public void setFKP(String fKP) {
        this.fKP = fKP;
    }

    public String getGBP() {
        return gBP;
    }

    public void setGBP(String gBP) {
        this.gBP = gBP;
    }

    public String getGEL() {
        return gEL;
    }

    public void setGEL(String gEL) {
        this.gEL = gEL;
    }

    public String getGGP() {
        return gGP;
    }

    public void setGGP(String gGP) {
        this.gGP = gGP;
    }

    public String getGHS() {
        return gHS;
    }

    public void setGHS(String gHS) {
        this.gHS = gHS;
    }

    public String getGIP() {
        return gIP;
    }

    public void setGIP(String gIP) {
        this.gIP = gIP;
    }

    public String getGMD() {
        return gMD;
    }

    public void setGMD(String gMD) {
        this.gMD = gMD;
    }

    public String getGNF() {
        return gNF;
    }

    public void setGNF(String gNF) {
        this.gNF = gNF;
    }

    public String getGTQ() {
        return gTQ;
    }

    public void setGTQ(String gTQ) {
        this.gTQ = gTQ;
    }

    public String getGYD() {
        return gYD;
    }

    public void setGYD(String gYD) {
        this.gYD = gYD;
    }

    public String getHKD() {
        return hKD;
    }

    public void setHKD(String hKD) {
        this.hKD = hKD;
    }

    public String getHNL() {
        return hNL;
    }

    public void setHNL(String hNL) {
        this.hNL = hNL;
    }

    public String getHRK() {
        return hRK;
    }

    public void setHRK(String hRK) {
        this.hRK = hRK;
    }

    public String getHTG() {
        return hTG;
    }

    public void setHTG(String hTG) {
        this.hTG = hTG;
    }

    public String getHUF() {
        return hUF;
    }

    public void setHUF(String hUF) {
        this.hUF = hUF;
    }

    public String getIDR() {
        return iDR;
    }

    public void setIDR(String iDR) {
        this.iDR = iDR;
    }

    public String getILS() {
        return iLS;
    }

    public void setILS(String iLS) {
        this.iLS = iLS;
    }

    public String getIMP() {
        return iMP;
    }

    public void setIMP(String iMP) {
        this.iMP = iMP;
    }

    public String getINR() {
        return iNR;
    }

    public void setINR(String iNR) {
        this.iNR = iNR;
    }

    public String getIQD() {
        return iQD;
    }

    public void setIQD(String iQD) {
        this.iQD = iQD;
    }

    public String getIRR() {
        return iRR;
    }

    public void setIRR(String iRR) {
        this.iRR = iRR;
    }

    public String getISK() {
        return iSK;
    }

    public void setISK(String iSK) {
        this.iSK = iSK;
    }

    public String getJEP() {
        return jEP;
    }

    public void setJEP(String jEP) {
        this.jEP = jEP;
    }

    public String getJMD() {
        return jMD;
    }

    public void setJMD(String jMD) {
        this.jMD = jMD;
    }

    public String getJOD() {
        return jOD;
    }

    public void setJOD(String jOD) {
        this.jOD = jOD;
    }

    public String getJPY() {
        return jPY;
    }

    public void setJPY(String jPY) {
        this.jPY = jPY;
    }

    public String getKES() {
        return kES;
    }

    public void setKES(String kES) {
        this.kES = kES;
    }

    public String getKGS() {
        return kGS;
    }

    public void setKGS(String kGS) {
        this.kGS = kGS;
    }

    public String getKHR() {
        return kHR;
    }

    public void setKHR(String kHR) {
        this.kHR = kHR;
    }

    public String getKMF() {
        return kMF;
    }

    public void setKMF(String kMF) {
        this.kMF = kMF;
    }

    public String getKPW() {
        return kPW;
    }

    public void setKPW(String kPW) {
        this.kPW = kPW;
    }

    public String getKRW() {
        return kRW;
    }

    public void setKRW(String kRW) {
        this.kRW = kRW;
    }

    public String getKWD() {
        return kWD;
    }

    public void setKWD(String kWD) {
        this.kWD = kWD;
    }

    public String getKYD() {
        return kYD;
    }

    public void setKYD(String kYD) {
        this.kYD = kYD;
    }

    public String getKZT() {
        return kZT;
    }

    public void setKZT(String kZT) {
        this.kZT = kZT;
    }

    public String getLAK() {
        return lAK;
    }

    public void setLAK(String lAK) {
        this.lAK = lAK;
    }

    public String getLBP() {
        return lBP;
    }

    public void setLBP(String lBP) {
        this.lBP = lBP;
    }

    public String getLKR() {
        return lKR;
    }

    public void setLKR(String lKR) {
        this.lKR = lKR;
    }

    public String getLRD() {
        return lRD;
    }

    public void setLRD(String lRD) {
        this.lRD = lRD;
    }

    public String getLSL() {
        return lSL;
    }

    public void setLSL(String lSL) {
        this.lSL = lSL;
    }

    public String getLYD() {
        return lYD;
    }

    public void setLYD(String lYD) {
        this.lYD = lYD;
    }

    public String getMAD() {
        return mAD;
    }

    public void setMAD(String mAD) {
        this.mAD = mAD;
    }

    public String getMDL() {
        return mDL;
    }

    public void setMDL(String mDL) {
        this.mDL = mDL;
    }

    public String getMGA() {
        return mGA;
    }

    public void setMGA(String mGA) {
        this.mGA = mGA;
    }

    public String getMKD() {
        return mKD;
    }

    public void setMKD(String mKD) {
        this.mKD = mKD;
    }

    public String getMMK() {
        return mMK;
    }

    public void setMMK(String mMK) {
        this.mMK = mMK;
    }

    public String getMNT() {
        return mNT;
    }

    public void setMNT(String mNT) {
        this.mNT = mNT;
    }

    public String getMOP() {
        return mOP;
    }

    public void setMOP(String mOP) {
        this.mOP = mOP;
    }

    public String getMRO() {
        return mRO;
    }

    public void setMRO(String mRO) {
        this.mRO = mRO;
    }

    public String getMRU() {
        return mRU;
    }

    public void setMRU(String mRU) {
        this.mRU = mRU;
    }

    public String getMUR() {
        return mUR;
    }

    public void setMUR(String mUR) {
        this.mUR = mUR;
    }

    public String getMVR() {
        return mVR;
    }

    public void setMVR(String mVR) {
        this.mVR = mVR;
    }

    public String getMWK() {
        return mWK;
    }

    public void setMWK(String mWK) {
        this.mWK = mWK;
    }

    public String getMXN() {
        return mXN;
    }

    public void setMXN(String mXN) {
        this.mXN = mXN;
    }

    public String getMYR() {
        return mYR;
    }

    public void setMYR(String mYR) {
        this.mYR = mYR;
    }

    public String getMZN() {
        return mZN;
    }

    public void setMZN(String mZN) {
        this.mZN = mZN;
    }

    public String getNAD() {
        return nAD;
    }

    public void setNAD(String nAD) {
        this.nAD = nAD;
    }

    public String getNGN() {
        return nGN;
    }

    public void setNGN(String nGN) {
        this.nGN = nGN;
    }

    public String getNIO() {
        return nIO;
    }

    public void setNIO(String nIO) {
        this.nIO = nIO;
    }

    public String getNOK() {
        return nOK;
    }

    public void setNOK(String nOK) {
        this.nOK = nOK;
    }

    public String getNPR() {
        return nPR;
    }

    public void setNPR(String nPR) {
        this.nPR = nPR;
    }

    public String getNZD() {
        return nZD;
    }

    public void setNZD(String nZD) {
        this.nZD = nZD;
    }

    public String getOMR() {
        return oMR;
    }

    public void setOMR(String oMR) {
        this.oMR = oMR;
    }

    public String getPAB() {
        return pAB;
    }

    public void setPAB(String pAB) {
        this.pAB = pAB;
    }

    public String getPEN() {
        return pEN;
    }

    public void setPEN(String pEN) {
        this.pEN = pEN;
    }

    public String getPGK() {
        return pGK;
    }

    public void setPGK(String pGK) {
        this.pGK = pGK;
    }

    public String getPHP() {
        return pHP;
    }

    public void setPHP(String pHP) {
        this.pHP = pHP;
    }

    public String getPKR() {
        return pKR;
    }

    public void setPKR(String pKR) {
        this.pKR = pKR;
    }

    public String getPLN() {
        return pLN;
    }

    public void setPLN(String pLN) {
        this.pLN = pLN;
    }

    public String getPYG() {
        return pYG;
    }

    public void setPYG(String pYG) {
        this.pYG = pYG;
    }

    public String getQAR() {
        return qAR;
    }

    public void setQAR(String qAR) {
        this.qAR = qAR;
    }

    public String getRON() {
        return rON;
    }

    public void setRON(String rON) {
        this.rON = rON;
    }

    public String getRSD() {
        return rSD;
    }

    public void setRSD(String rSD) {
        this.rSD = rSD;
    }

    public String getRUB() {
        return rUB;
    }

    public void setRUB(String rUB) {
        this.rUB = rUB;
    }

    public String getRWF() {
        return rWF;
    }

    public void setRWF(String rWF) {
        this.rWF = rWF;
    }

    public String getSAR() {
        return sAR;
    }

    public void setSAR(String sAR) {
        this.sAR = sAR;
    }

    public String getSBD() {
        return sBD;
    }

    public void setSBD(String sBD) {
        this.sBD = sBD;
    }

    public String getSCR() {
        return sCR;
    }

    public void setSCR(String sCR) {
        this.sCR = sCR;
    }

    public String getSDG() {
        return sDG;
    }

    public void setSDG(String sDG) {
        this.sDG = sDG;
    }

    public String getSEK() {
        return sEK;
    }

    public void setSEK(String sEK) {
        this.sEK = sEK;
    }

    public String getSGD() {
        return sGD;
    }

    public void setSGD(String sGD) {
        this.sGD = sGD;
    }

    public String getSHP() {
        return sHP;
    }

    public void setSHP(String sHP) {
        this.sHP = sHP;
    }

    public String getSLL() {
        return sLL;
    }

    public void setSLL(String sLL) {
        this.sLL = sLL;
    }

    public String getSOS() {
        return sOS;
    }

    public void setSOS(String sOS) {
        this.sOS = sOS;
    }

    public String getSRD() {
        return sRD;
    }

    public void setSRD(String sRD) {
        this.sRD = sRD;
    }

    public String getSSP() {
        return sSP;
    }

    public void setSSP(String sSP) {
        this.sSP = sSP;
    }

    public String getSTD() {
        return sTD;
    }

    public void setSTD(String sTD) {
        this.sTD = sTD;
    }

    public String getSTN() {
        return sTN;
    }

    public void setSTN(String sTN) {
        this.sTN = sTN;
    }

    public String getSVC() {
        return sVC;
    }

    public void setSVC(String sVC) {
        this.sVC = sVC;
    }

    public String getSYP() {
        return sYP;
    }

    public void setSYP(String sYP) {
        this.sYP = sYP;
    }

    public String getSZL() {
        return sZL;
    }

    public void setSZL(String sZL) {
        this.sZL = sZL;
    }

    public String getTHB() {
        return tHB;
    }

    public void setTHB(String tHB) {
        this.tHB = tHB;
    }

    public String getTJS() {
        return tJS;
    }

    public void setTJS(String tJS) {
        this.tJS = tJS;
    }

    public String getTMT() {
        return tMT;
    }

    public void setTMT(String tMT) {
        this.tMT = tMT;
    }

    public String getTND() {
        return tND;
    }

    public void setTND(String tND) {
        this.tND = tND;
    }

    public String getTOP() {
        return tOP;
    }

    public void setTOP(String tOP) {
        this.tOP = tOP;
    }

    public String getTRY() {
        return tRY;
    }

    public void setTRY(String tRY) {
        this.tRY = tRY;
    }

    public String getTTD() {
        return tTD;
    }

    public void setTTD(String tTD) {
        this.tTD = tTD;
    }

    public String getTWD() {
        return tWD;
    }

    public void setTWD(String tWD) {
        this.tWD = tWD;
    }

    public String getTZS() {
        return tZS;
    }

    public void setTZS(String tZS) {
        this.tZS = tZS;
    }

    public String getUAH() {
        return uAH;
    }

    public void setUAH(String uAH) {
        this.uAH = uAH;
    }

    public String getUGX() {
        return uGX;
    }

    public void setUGX(String uGX) {
        this.uGX = uGX;
    }

    public String getUSD() {
        return uSD;
    }

    public void setUSD(String uSD) {
        this.uSD = uSD;
    }

    public String getUYU() {
        return uYU;
    }

    public void setUYU(String uYU) {
        this.uYU = uYU;
    }

    public String getUZS() {
        return uZS;
    }

    public void setUZS(String uZS) {
        this.uZS = uZS;
    }

    public String getVEF() {
        return vEF;
    }

    public void setVEF(String vEF) {
        this.vEF = vEF;
    }

    public String getVES() {
        return vES;
    }

    public void setVES(String vES) {
        this.vES = vES;
    }

    public String getVND() {
        return vND;
    }

    public void setVND(String vND) {
        this.vND = vND;
    }

    public String getVUV() {
        return vUV;
    }

    public void setVUV(String vUV) {
        this.vUV = vUV;
    }

    public String getWST() {
        return wST;
    }

    public void setWST(String wST) {
        this.wST = wST;
    }

    public String getXAF() {
        return xAF;
    }

    public void setXAF(String xAF) {
        this.xAF = xAF;
    }

    public String getXAG() {
        return xAG;
    }

    public void setXAG(String xAG) {
        this.xAG = xAG;
    }

    public String getXAU() {
        return xAU;
    }

    public void setXAU(String xAU) {
        this.xAU = xAU;
    }

    public String getXCD() {
        return xCD;
    }

    public void setXCD(String xCD) {
        this.xCD = xCD;
    }

    public String getXDR() {
        return xDR;
    }

    public void setXDR(String xDR) {
        this.xDR = xDR;
    }

    public String getXOF() {
        return xOF;
    }

    public void setXOF(String xOF) {
        this.xOF = xOF;
    }

    public String getXPD() {
        return xPD;
    }

    public void setXPD(String xPD) {
        this.xPD = xPD;
    }

    public String getXPF() {
        return xPF;
    }

    public void setXPF(String xPF) {
        this.xPF = xPF;
    }

    public String getXPT() {
        return xPT;
    }

    public void setXPT(String xPT) {
        this.xPT = xPT;
    }

    public String getYER() {
        return yER;
    }

    public void setYER(String yER) {
        this.yER = yER;
    }

    public String getZAR() {
        return zAR;
    }

    public void setZAR(String zAR) {
        this.zAR = zAR;
    }

    public String getZMW() {
        return zMW;
    }

    public void setZMW(String zMW) {
        this.zMW = zMW;
    }

    public String getZWL() {
        return zWL;
    }

    public void setZWL(String zWL) {
        this.zWL = zWL;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("aED", aED).append("aFN", aFN).append("aLL", aLL).append("aMD", aMD).append("aNG", aNG).append("aOA", aOA).append("aRS", aRS).append("aUD", aUD).append("aWG", aWG).append("aZN", aZN).append("bAM", bAM).append("bBD", bBD).append("bDT", bDT).append("bGN", bGN).append("bHD", bHD).append("bIF", bIF).append("bMD", bMD).append("bND", bND).append("bOB", bOB).append("bRL", bRL).append("bSD", bSD).append("bTC", bTC).append("bTN", bTN).append("bWP", bWP).append("bYN", bYN).append("bZD", bZD).append("cAD", cAD).append("cDF", cDF).append("cHF", cHF).append("cLF", cLF).append("cLP", cLP).append("cNH", cNH).append("cNY", cNY).append("cOP", cOP).append("cRC", cRC).append("cUC", cUC).append("cUP", cUP).append("cVE", cVE).append("cZK", cZK).append("dJF", dJF).append("dKK", dKK).append("dOP", dOP).append("dZD", dZD).append("eGP", eGP).append("eRN", eRN).append("eTB", eTB).append("eUR", eUR).append("fJD", fJD).append("fKP", fKP).append("gBP", gBP).append("gEL", gEL).append("gGP", gGP).append("gHS", gHS).append("gIP", gIP).append("gMD", gMD).append("gNF", gNF).append("gTQ", gTQ).append("gYD", gYD).append("hKD", hKD).append("hNL", hNL).append("hRK", hRK).append("hTG", hTG).append("hUF", hUF).append("iDR", iDR).append("iLS", iLS).append("iMP", iMP).append("iNR", iNR).append("iQD", iQD).append("iRR", iRR).append("iSK", iSK).append("jEP", jEP).append("jMD", jMD).append("jOD", jOD).append("jPY", jPY).append("kES", kES).append("kGS", kGS).append("kHR", kHR).append("kMF", kMF).append("kPW", kPW).append("kRW", kRW).append("kWD", kWD).append("kYD", kYD).append("kZT", kZT).append("lAK", lAK).append("lBP", lBP).append("lKR", lKR).append("lRD", lRD).append("lSL", lSL).append("lYD", lYD).append("mAD", mAD).append("mDL", mDL).append("mGA", mGA).append("mKD", mKD).append("mMK", mMK).append("mNT", mNT).append("mOP", mOP).append("mRO", mRO).append("mRU", mRU).append("mUR", mUR).append("mVR", mVR).append("mWK", mWK).append("mXN", mXN).append("mYR", mYR).append("mZN", mZN).append("nAD", nAD).append("nGN", nGN).append("nIO", nIO).append("nOK", nOK).append("nPR", nPR).append("nZD", nZD).append("oMR", oMR).append("pAB", pAB).append("pEN", pEN).append("pGK", pGK).append("pHP", pHP).append("pKR", pKR).append("pLN", pLN).append("pYG", pYG).append("qAR", qAR).append("rON", rON).append("rSD", rSD).append("rUB", rUB).append("rWF", rWF).append("sAR", sAR).append("sBD", sBD).append("sCR", sCR).append("sDG", sDG).append("sEK", sEK).append("sGD", sGD).append("sHP", sHP).append("sLL", sLL).append("sOS", sOS).append("sRD", sRD).append("sSP", sSP).append("sTD", sTD).append("sTN", sTN).append("sVC", sVC).append("sYP", sYP).append("sZL", sZL).append("tHB", tHB).append("tJS", tJS).append("tMT", tMT).append("tND", tND).append("tOP", tOP).append("tRY", tRY).append("tTD", tTD).append("tWD", tWD).append("tZS", tZS).append("uAH", uAH).append("uGX", uGX).append("uSD", uSD).append("uYU", uYU).append("uZS", uZS).append("vEF", vEF).append("vES", vES).append("vND", vND).append("vUV", vUV).append("wST", wST).append("xAF", xAF).append("xAG", xAG).append("xAU", xAU).append("xCD", xCD).append("xDR", xDR).append("xOF", xOF).append("xPD", xPD).append("xPF", xPF).append("xPT", xPT).append("yER", yER).append("zAR", zAR).append("zMW", zMW).append("zWL", zWL).toString();
    }
}
