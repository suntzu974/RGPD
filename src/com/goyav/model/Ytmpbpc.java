package com.goyav.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.SerializedName;

@XmlRootElement(name = "ytmpbpc")
@XmlAccessorType (XmlAccessType.FIELD)
public class Ytmpbpc {
		@SerializedName("YLIN_0")
		private String YLIN_0;
		@SerializedName("BCGCOD_0")
		private String BCGCOD_0;
		@SerializedName("BPCNUM_0")
		private String BPCNUM_0; 
		@SerializedName("BPCCSTA_0")
		private String BPCSTA_0;  
		@SerializedName("BPNAM_0")
		private String BPRNAM_0;       
		@SerializedName("BPNAM_1")
		private String BPRNAM_1;
		@SerializedName("BPRSHO_0")
		private String BPRSHO_0; 
		@SerializedName("BPRLOG_0")
		private String BPRLOG_0; 
		@SerializedName("CRN_0")
		private String CRN_0;
		@SerializedName("NAF_0")
		private String NAF_0; 
		@SerializedName("CRY_0")
		private String CRY_0; 
		@SerializedName("CUR_0")
		private String CUR_0; 
		@SerializedName("VACBPR_0")
		private String VACBPR_0;
		@SerializedName("PTE_0")
		private String PTE_0; 
		@SerializedName("ACCCOD_0")
		private String ACCCOD_0; 
		@SerializedName("TSCCOD_0")
		private String TSCCOD_0;       
		@SerializedName("TSCCOD_1")
		private String TSCCOD_1;
		@SerializedName("OSTAUZ_0")
		private String OSTAUZ_0;   
		@SerializedName("REP_0")
		private String REP_0; 
		@SerializedName("REP_1")
		private String REP_1; 
		@SerializedName("YBCG_COMPT_0")
		private String YBCG_COMPT_0; 
		@SerializedName("YBPC_RECOUVR_0")
		private String YBPC_RECOUVR_0; 
		@SerializedName("YCATCPT_0")
		private String YCATCPT_0; 
		@SerializedName("YSCATCPT_0")
		private String YSCATCPT_0; 
		@SerializedName("BPAADD_0")
		private String BPAADD_0; 
		@SerializedName("BPADES_0")
		private String BPADES_0; 
		@SerializedName("BPAADDLIG_0")
		private String BPAADDLIG_0;    
		@SerializedName("BPAADDLIG_1")
		private String BPAADDLIG_1; 
		@SerializedName("BPAADDLIG_2")
		private String BPAADDLIG_2;   
		@SerializedName("POSTCOD_0")
		private String POSCOD_0;  
		@SerializedName("CTY_0")
		private String CTY_0; 
		@SerializedName("BCRY_0")
		private String BCRY_0; 
		@SerializedName("TEL_0")
		private String TEL_0;          
		@SerializedName("TEL_1")
		private String TEL_1; 
		@SerializedName("WEB_0")
		private String WEB_0;
		
		public Ytmpbpc() {
			this.YLIN_0 = "1";
			this.BCGCOD_0 = "92";
			this.BPCNUM_0 = "";
			this.BPCSTA_0 = "2";
			this.BPRSHO_0 = "COMPTOIR";
			this.NAF_0 = "";
			this.CUR_0 = "EUR";
			this.VACBPR_0 = "DOM";
			this.PTE_0 = "CHQCPT";
			this.ACCCOD_0 = "CPT";
			this.TSCCOD_0 = "";
			this.TSCCOD_1 = "";
			this.OSTAUZ_0 = "1";
			this.REP_0 = "KWONGCHEONG";
			this.REP_1 = "";
			this.YBCG_COMPT_0 = "2";
			this.YBPC_RECOUVR_0 = "50";
			this.YCATCPT_0 = "1";
			this.YSCATCPT_0 = "1";
			this.BPAADD_0 = "A1";
			this.BPADES_0 = "";
			this.BPAADDLIG_2 = "";
			this.TEL_1 = "";
			
		}
		public Ytmpbpc(String bPRNAM_0,	String bPRNAM_1, String bPRLOG_0, String cRN_0, String cRY_0,
				String bPAADDLIG_0, String bPAADDLIG_1,	String pOSCOD_0, String cTY_0, String bCRY_0,
				String tEL_0, String wEB_0) {
			
			this.YLIN_0 = "1";
			this.BCGCOD_0 = "92";
			this.BPCNUM_0 = "";
			this.BPCSTA_0 = "2";
			this.BPRNAM_0 = bPRNAM_0;
			this.BPRNAM_1 = bPRNAM_1;
			this.BPRSHO_0 = "COMPTOIR";
			this.BPRLOG_0 = bPRLOG_0;
			this.CRN_0 = cRN_0;
			this.NAF_0 = "";
			this.CRY_0 = cRY_0;
			this.CUR_0 = "EUR";
			this.VACBPR_0 = "DOM";
			this.PTE_0 = "CHQCPT";
			this.ACCCOD_0 = "CPT";
			this.TSCCOD_0 = "";
			this.TSCCOD_1 = "";
			this.OSTAUZ_0 = "1";
			this.REP_0 = "KWONGCHEONG";
			this.REP_1 = "";
			this.YBCG_COMPT_0 = "2";
			this.YBPC_RECOUVR_0 = "50";
			this.YCATCPT_0 = "1";
			this.YSCATCPT_0 = "1";
			this.BPAADD_0 = "A1";
			this.BPADES_0 = "";
			this.BPAADDLIG_0 = bPAADDLIG_0;
			this.BPAADDLIG_1 = bPAADDLIG_1;
			this.BPAADDLIG_2 = "";
			this.POSCOD_0 = pOSCOD_0;
			this.CTY_0 = cTY_0;
			this.BCRY_0 = bCRY_0;
			this.TEL_0 = tEL_0;
			this.TEL_1 = "";
			this.WEB_0 = wEB_0;
		}

		public String getYLIN_0() {
			return YLIN_0;
		}

		public void setYLIN_0(String yLIN_0) {
			YLIN_0 = yLIN_0;
		}

		public String getBCGCOD_0() {
			return BCGCOD_0;
		}

		public void setBCGCOD_0(String bCGCOD_0) {
			BCGCOD_0 = bCGCOD_0;
		}

		public String getBPCNUM_0() {
			return BPCNUM_0;
		}

		public void setBPCNUM_0(String bPCNUM_0) {
			BPCNUM_0 = bPCNUM_0;
		}

		public String getBPCSTA_0() {
			return BPCSTA_0;
		}

		public void setBPCSTA_0(String bPCSTA_0) {
			BPCSTA_0 = bPCSTA_0;
		}

		public String getBPRNAM_0() {
			return BPRNAM_0;
		}

		public void setBPRNAM_0(String bPRNAM_0) {
			BPRNAM_0 = bPRNAM_0;
		}

		public String getBPRNAM_1() {
			return BPRNAM_1;
		}

		public void setBPRNAM_1(String bPRNAM_1) {
			BPRNAM_1 = bPRNAM_1;
		}

		public String getBPRSHO_0() {
			return BPRSHO_0;
		}

		public void setBPRSHO_0(String bPRSHO_0) {
			BPRSHO_0 = bPRSHO_0;
		}

		public String getBPRLOG_0() {
			return BPRLOG_0;
		}

		public void setBPRLOG_0(String bPRLOG_0) {
			BPRLOG_0 = bPRLOG_0;
		}

		public String getCRN_0() {
			return CRN_0;
		}

		public void setCRN_0(String cRN_0) {
			CRN_0 = cRN_0;
		}

		public String getNAF_0() {
			return NAF_0;
		}

		public void setNAF_0(String nAF_0) {
			NAF_0 = nAF_0;
		}

		public String getCRY_0() {
			return CRY_0;
		}

		public void setCRY_0(String cRY_0) {
			CRY_0 = cRY_0;
		}

		public String getCUR_0() {
			return CUR_0;
		}

		public void setCUR_0(String cUR_0) {
			CUR_0 = cUR_0;
		}

		public String getVACBPR_0() {
			return VACBPR_0;
		}

		public void setVACBPR_0(String vACBPR_0) {
			VACBPR_0 = vACBPR_0;
		}

		public String getPTE_0() {
			return PTE_0;
		}

		public void setPTE_0(String pTE_0) {
			PTE_0 = pTE_0;
		}

		public String getACCCOD_0() {
			return ACCCOD_0;
		}

		public void setACCCOD_0(String aCCCOD_0) {
			ACCCOD_0 = aCCCOD_0;
		}

		public String getTSCCOD_0() {
			return TSCCOD_0;
		}

		public void setTSCCOD_0(String tSCCOD_0) {
			TSCCOD_0 = tSCCOD_0;
		}

		public String getTSCCOD_1() {
			return TSCCOD_1;
		}

		public void setTSCCOD_1(String tSCCOD_1) {
			TSCCOD_1 = tSCCOD_1;
		}

		public String getOSTAUZ_0() {
			return OSTAUZ_0;
		}

		public void setOSTAUZ_0(String oSTAUZ_0) {
			OSTAUZ_0 = oSTAUZ_0;
		}

		public String getREP_0() {
			return REP_0;
		}

		public void setREP_0(String rEP_0) {
			REP_0 = rEP_0;
		}

		public String getREP_1() {
			return REP_1;
		}

		public void setREP_1(String rEP_1) {
			REP_1 = rEP_1;
		}

		public String getYBCG_COMPT_0() {
			return YBCG_COMPT_0;
		}

		public void setYBCG_COMPT_0(String yBCG_COMPT_0) {
			YBCG_COMPT_0 = yBCG_COMPT_0;
		}

		public String getYBPC_RECOUVR_0() {
			return YBPC_RECOUVR_0;
		}

		public void setYBPC_RECOUVR_0(String yBPC_RECOUVR_0) {
			YBPC_RECOUVR_0 = yBPC_RECOUVR_0;
		}

		public String getYCATCPT_0() {
			return YCATCPT_0;
		}

		public void setYCATCPT_0(String yCATCPT_0) {
			YCATCPT_0 = yCATCPT_0;
		}

		public String getYSCATCPT_0() {
			return YSCATCPT_0;
		}

		public void setYSCATCPT_0(String ySCATCPT_0) {
			YSCATCPT_0 = ySCATCPT_0;
		}
		public String getBPAADD_0() {
			return BPAADD_0;
		}

		public void setBPAADD_0(String bPAADD_0) {
			BPAADD_0 = bPAADD_0;
		}

		public String getBPADES_0() {
			return BPADES_0;
		}

		public void setBPADES_0(String bPADES_0) {
			BPADES_0 = bPADES_0;
		}

		public String getBPAADDLIG_0() {
			return BPAADDLIG_0;
		}

		public void setBPAADDLIG_0(String bPAADDLIG_0) {
			BPAADDLIG_0 = bPAADDLIG_0;
		}

		public String getBPAADDLIG_1() {
			return BPAADDLIG_1;
		}

		public void setBPAADDLIG_1(String bPAADDLIG_1) {
			BPAADDLIG_1 = bPAADDLIG_1;
		}

		public String getBPAADDLIG_2() {
			return BPAADDLIG_2;
		}

		public void setBPAADDLIG_2(String bPAADDLIG_2) {
			BPAADDLIG_2 = bPAADDLIG_2;
		}

		public String getPOSCOD_0() {
			return POSCOD_0;
		}

		public void setPOSCOD_0(String pOSCOD_0) {
			POSCOD_0 = pOSCOD_0;
		}

		public String getCTY_0() {
			return CTY_0;
		}

		public void setCTY_0(String cTY_0) {
			CTY_0 = cTY_0;
		}

		public String getBCRY_0() {
			return BCRY_0;
		}

		public void setBCRY_0(String bCRY_0) {
			BCRY_0 = bCRY_0;
		}

		public String getTEL_0() {
			return TEL_0;
		}

		public void setTEL_0(String tEL_0) {
			TEL_0 = tEL_0;
		}

		public String getTEL_1() {
			return TEL_1;
		}

		public void setTEL_1(String tEL_1) {
			TEL_1 = tEL_1;
		}

		public String getWEB_0() {
			return WEB_0;
		}

		public void setWEB_0(String wEB_0) {
			WEB_0 = wEB_0;
		}          
}
