package com.project;

import java.util.List;

import org.thethingsnetwork.data.common.Metadata;
import org.thethingsnetwork.data.common.Metadata.Gateway;
import org.thethingsnetwork.data.common.messages.DataMessage;
import org.thethingsnetwork.data.common.messages.UplinkMessage;

public class TTNClient {

	protected static void showData(DataMessage data) {
		// Data
		 System.out.println();
		 System.out.println("Data :");
//		 System.out.println("App_id : " + ((UplinkMessage) data).getAppId());
		 System.out.println("Counter : " + ((UplinkMessage) data).getCounter());
//		 System.out.println("Dev_id : " + ((UplinkMessage) data).getDevId());
//		 System.out.println("HW serial : " + ((UplinkMessage) data).getHardwareSerial());
		 System.out.println("Port : " + ((UplinkMessage) data).getPort());

		 // Metdata
		 Metadata md = ((UplinkMessage) data).getMetadata();
		 System.out.println("Metadata :");
		 System.out.println("BitRate : " + md.getBitRate());
		 System.out.println("CodingRate: " + md.getCodingRate());
		 System.out.println("DataRate : " + md.getDataRate());
		 System.out.println("Frequecy : " + md.getFrequency());
		 System.out.println("Modulation: " + md.getModulation());
		 System.out.println("Time : " + md.getTime());

		 // Gateway data
		 List<Gateway> gw = ((UplinkMessage) data).getMetadata().getGateways();
		 System.out.println("Gateways : ");
//		 System.out.println("Altitude : " + gw.get(0).getAltitude());
		 System.out.println("Channel : " + gw.get(0).getChannel());
		 System.out.println("GatewayId : " + gw.get(0).getId());
//		 System.out.println("Latitude : " + gw.get(0).getLatitude());
//		 System.out.println("Longitude : " + gw.get(0).getLongitude());
		 System.out.println("RFChain : " + gw.get(0).getRfChain());
		 System.out.println("RSSI : " + gw.get(0).getRssi());
		 System.out.println("SNR : " + gw.get(0).getSnr());
		 System.out.println("Time : " + gw.get(0).getTime());
		 System.out.println("Timestamp : " + gw.get(0).getTimestamp());

		 // Payload
		 System.out.println("Payload : ");
		 System.out.println("Data : " + ((UplinkMessage)
		data).getPayloadFields().get("payload"));
		 byte[] payload = ((UplinkMessage) data).getPayloadRaw();
		 System.out.print( "Raw data : ");
		 for(int i=0; i<payload.length; i++) {
			char ch = (char) payload[i];
			System.out.print(ch);
		 }
		 System.out.println();
		 System.out.println();
//		 alertTest((String) ((UplinkMessage) data).getPayloadFields().get("payload"));
		 System.out.println();
		 System.out.println();
		}
	

}
