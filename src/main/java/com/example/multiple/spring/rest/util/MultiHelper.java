package com.example.multiple.spring.rest.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author mlahariya
 * @version 1.0, Dec 2016
 */

@Component
public class MultiHelper {

    private static final Logger LOG = LoggerFactory.getLogger(MultiHelper.class);

    private static final int NPA_LEN = 3;
    private static final int NXX_LEN = 3;
    private static final int NUMBER_LEN = 4;

    @Autowired
    private DataEncryptor dataEncryptor;

    public DataEncryptor getDataEncryptor() {
        return dataEncryptor;
    }

    public void setDataEncryptor(DataEncryptor dataEncryptor) {
        this.dataEncryptor = dataEncryptor;
    }

    public String createMyAccountNumber(String billingRegion, String houseNumber, String custNumber) {

        StringBuffer accountNumberStringBuffer = new StringBuffer(3);
        String massagedBillingRegion = null;
        String massagedHouseNumber = null;
        String massagedCustomerNumber = null;

        massagedBillingRegion = this.formatMdpBillingRegion(billingRegion);
        massagedHouseNumber = this.formatMdpHouseNumber(houseNumber);
        massagedCustomerNumber = this.formatMdpCustNumber(custNumber);

        accountNumberStringBuffer.append(massagedBillingRegion);
        accountNumberStringBuffer.append(massagedHouseNumber);
        accountNumberStringBuffer.append(massagedCustomerNumber);

        return accountNumberStringBuffer.toString();
    }

    public String formatMdpBillingRegion(String billingRegion) {
        return StringUtils.leftPad(StringUtils.strip(billingRegion), 5, '0');
    }

    public String formatMdpBillingRegion(Long billingRegion) {
        String mdpBr = null;
        if (billingRegion != null) {
            mdpBr = StringUtils.leftPad(StringUtils.strip(billingRegion.toString()), 5, '0');
        }
        return mdpBr;
    }

    public String formatMdpCustNumber(String custNumber) {
        return StringUtils.leftPad(StringUtils.strip(custNumber), 2, '0');
    }

    public String formatMdpHouseNumber(String houseNumber) {
        return StringUtils.leftPad(StringUtils.strip(houseNumber), 6, '0');
    }

    public String getGspMarketFromAccountNumber(String accountNumber) {

        int gspAccountNumberLength = 16;
        int systemLength = 4;
        int principalStart = 4;
        int principalLength = 2;
        int agentStart = 6;
        int agentLength = 3;
        String principalSuffix = "00";
        String agentSuffix = "0";

        String market = null;
        if (StringUtils.isBlank(accountNumber) || (accountNumber.length() != gspAccountNumberLength)) {
            return null;
        }

        String system = StringUtils.left(accountNumber, systemLength);
        String principal = StringUtils.mid(accountNumber, principalStart, principalLength) + principalSuffix;
        String agent = StringUtils.mid(accountNumber, agentStart, agentLength) + agentSuffix;

        StringBuffer stringBuffer = new StringBuffer(3);
        stringBuffer.append(system);
        stringBuffer.append(principal);
        stringBuffer.append(agent);
        market = stringBuffer.toString();
        return market;
    }

    public String getGspFromBusinessUnit(String businessUnit) {
        String prin = null;
        prin = StringUtils.substring(businessUnit, 4, 8);
        return prin;
    }

    public String getGspRoutingFromBusinessUnit(String businessUnit) {
        String routing = null;
        routing = StringUtils.substring(businessUnit, 0, 4);
        return routing;
    }

    public String getMdpBillingRegionFromAccount(String accountNumber) {
        String br = null;
        br = this.formatMdpBillingRegion(StringUtils.substring(accountNumber, 0, 5));
        return br;
    }

    public Long getMdpBillingRegionFromAccountAsLong(String accountNumber) {
        String br = null;
        try {
            br = this.formatMdpBillingRegion(StringUtils.substring(accountNumber, 0, 5));
            return Long.parseLong(br);
        } catch (Exception e) {
            LOG.debug("Error while parsing Billing Region", e);
        }
        return null;
    }

    public String getMdpCustNumFromAccount(String accountNumber) {
        String cn = null;
        cn = this.formatMdpCustNumber(StringUtils.right(accountNumber, 2));
        return cn;
    }

    public Long getMdpCustNumFromAccountAsLong(String accountNumber) {
        String cn = null;
        try {
            cn = this.formatMdpCustNumber(StringUtils.right(accountNumber, 2));
            return Long.parseLong(cn);
        } catch (Exception e) {
            LOG.debug("Error while parsing Cust Num", e);
        }
        return null;
    }

    public String getMdpHouseNumFromAccount(String accountNumber) {
        String hn = null;
        hn = this.formatMdpHouseNumber(StringUtils.substring(accountNumber, 5, accountNumber.length() - 2));
        return hn;
    }

    public Long getMdpHouseNumFromAccountAsLong(String accountNumber) {
        String hn = null;
        try {
            hn = this.formatMdpHouseNumber(StringUtils.substring(accountNumber, 5, accountNumber.length() - 2));
            return Long.parseLong(hn);
        } catch (Exception e) {
            LOG.debug("Error while parsing House Num", e);
        }
        return null;
    }

    /**
     * Determines if a number can be converted to a Long class.
     * 
     * @param number
     *            A number.
     * @return True or false depending on if it can be parsed as a Long
     */
    public boolean isLong(String number) {
        if (isNumeric(number)) {
            try {
                Long.parseLong(number);
            } catch (Exception e) {
                LOG.warn(" Error in isLong()" + e, e);
                return false;

            }

            return true;
        }

        return false;
    }

    /**
     * Checks whether a string is <code>null</code>, empty, or contains a single
     * space.
     * 
     * @param str
     *            The string to check.
     * @return <code>true</code> if the string is <i>not</i> <code>null</code>,
     *         empty, or contains a single space. Otherwise, <code>false</code>.
     */
    public boolean isNotNull(String str) {
        return StringUtils.isNotBlank(str);
    }

    /**
     * Checks whether a string is <code>null</code>, empty, or contains a single
     * space.
     * 
     * @param str
     *            The string to check.
     * @return <code>true</code> if the string is <code>null</code>, empty, or
     *         contains whitespace. Otherwise, <code>false</code>.
     */
    public boolean isNull(String str) {
        return !isNotNull(str);
    }

    /**
     * Nullsafe equals...
     * 
     * @param s1
     * @param s2
     * @return
     */
    public boolean equalsString(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        } else if (s1 != null && s2 == null) {
            return false;
        } else if (s1 == null && s2 != null) {
            return false;
        }
        if (s1 != null && s2 != null) {
            return s1.equals(s2);
        }
        return false;
    }

    public String tnToNpa(String tn) {
        String npa = null;
        if (tn.length() >= getNpaLen()) {
            npa = tn.substring(0, getNpaLen());
        }
        return npa;
    }

    public String tnToNxx(String tn) {
        String nxx = null;
        if (tn.length() >= getNpaLen() + getNxxLen()) {
            nxx = tn.substring(getNpaLen(), getNpaLen() + getNxxLen());
        }
        return nxx;
    }

    public String tnToNumber(String tn) {
        String number = null;
        if (tn.length() >= getNpaLen() + getNxxLen() + getNumberLen()) {
            number = tn.substring(getNpaLen() + getNxxLen(), getNpaLen() + getNxxLen() + getNumberLen());
        }
        return number;
    }

    public static int getNpaLen() {
        return NPA_LEN;
    }

    public static int getNxxLen() {
        return NXX_LEN;
    }

    public static int getNumberLen() {
        return NUMBER_LEN;
    }

    /**
     * Returns a pretty-formatted date string in the format of
     * "MM/dd/yyyy HH:mm:ss"
     * 
     * @param cal
     * @return
     */
    public String formatDate(Calendar cal) {
        String str = null;
        if (cal != null) {
            String pattern = "MM/dd/yyyy HH:mm:ss";
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            try {
                str = format.format(cal.getTime());
            } catch (Exception e) {
                LOG.error(" Error Occured.", e);
            }
        }
        return str;
    }

    public static int compareUtility(Integer sortOrder1, Integer sortOrder2) {
        if (sortOrder1 != null && sortOrder2 != null)
            return sortOrder1.compareTo(sortOrder2);
        else if (sortOrder1 != null)
            return -1;
        else if (sortOrder2 != null)
            return 1;
        else
            return 0;
    }

    public boolean spaInList(String[] spas, String spa) {
        return (ArrayUtils.contains(spas, spa)
                || ArrayUtils.contains(spas, getGspRoutingFromBusinessUnit(spa) + getGspFromBusinessUnit(spa)) || ArrayUtils
                    .contains(spas, getGspRoutingFromBusinessUnit(spa)));

    }

    /**
     * Checks whether a string is positive long or not *
     * 
     * @param str
     *            The string to check.
     * @return <code>true</code> if the string is positive long Otherwise,
     *         <code>false</code>.
     */
    public boolean isPositveLongValue(String str) {
        boolean isValid = false;
        if (isLong(str)) {
            try {
                Long l = Long.parseLong(str);
                if (l > 0) {
                    isValid = true;
                }
            } catch (Exception e) {
                LOG.warn(" Error in isLong()" + e, e);
            }
        }
        return isValid;
    }

    /**
     * Returns whether a string consists of all numeric digits.
     * 
     * Note, this does not count Negative signs!
     * 
     * @param number
     * @return
     */
    public boolean isNumeric(String number) {
        if (number != null && number.matches("\\d+")) {
            return true;
        }
        return false;
    }

}
