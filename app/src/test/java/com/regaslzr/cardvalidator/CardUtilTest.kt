package com.regaslzr.cardvalidator

import com.regaslzr.cardvalidator.settings.CardType
import com.regaslzr.cardvalidator.utils.CardUtil
import org.junit.Assert.assertEquals
import org.junit.Test

class CardUtilTest {

    private fun setUpCardUtil() {
        CardUtil.setUp(true,
                listOf(CardType.Visa,
                CardType.MasterCard,
                CardType.Jcb))
    }

    @Test
    fun test_isCardValid_true() {
        println("\n\n----- test_isCardValid_true() -----\n")

        assertEquals(CardUtil.isValidCard(3530111333300000, 1234, 10, 2050), true)
        assertEquals(CardUtil.isValidCard(422222222222, 2222, 1, 2032), true)
        assertEquals(CardUtil.isValidCard(4123450131001381, 543, 12, 2025), true)
    }

    @Test
    fun test_isCardValid_false() {
        println("\n\n----- test_isCardValid_false() -----\n")

        assertEquals(CardUtil.isValidCard(41234567890, 1234, 13, 2050), false)
        assertEquals(CardUtil.isValidCard(9, 0, 11, 2018), false)
        assertEquals(CardUtil.isValidCard(-15, -10, 0, 1900), false)
    }

    //region CARD NUMBER test methods

    @Test
    fun test_isCardNumberValid_Length() {
        println("\n\n----- test_isCardNumberValid_Length() -----\n")

        val validNumber = 422222222222
        val invalidNumber = 41234567890

        println("Testing out Valid number $validNumber Length...")
        assertEquals(CardUtil.isValidCardNumber(validNumber), true)

        println("Testing out INvalid number $invalidNumber Length...")
        assertEquals(CardUtil.isValidCardNumber(invalidNumber), false)
    }

    @Test
    fun test_isCardNumberValid_By_Luhn() {
        println("\n\n----- test_isCardNumberValid_By_Luhn() -----\n")

        val validNumber = 422222222222
        val invalidNumber = 4123450131000509

        println("Testing out Valid number $validNumber by Luhn check...")
        assertEquals(CardUtil.isValidCardNumber(validNumber), true)

        println("Testing out INvalid number $invalidNumber by Luhn check...")
        assertEquals(CardUtil.isValidCardNumber(invalidNumber), false)
    }

    @Test
    fun test_isCardSupported_Type_true() {
        println("\n\n----- test_isCardSupported_Type_true() -----\n")

        setUpCardUtil()

        val sampleJCB = 3530111333300000
        val sampleVisa = 4123450131001381
        val sampleMasterCard = 5123456789012346

        println("Testing Visa support with sample number: $sampleVisa")
        assertEquals(CardUtil.isValidCardNumber(sampleVisa), true)

        println("Testing MasterCard support with sample number: $sampleMasterCard")
        assertEquals(CardUtil.isValidCardNumber(sampleMasterCard), true)

        println("Testing JCB support with sample number: $sampleJCB")
        assertEquals(CardUtil.isValidCardNumber(sampleJCB), true)
    }

    @Test
    fun test_isCardSupported_Type_false() {
        println("\n\n----- test_isCardSupported_Type_false() -----\n")

        setUpCardUtil()

        val sampleAmex = 340000000000009
        val sampleDinersClub = 30000000000004
        val sampleDiscover = 6011000000000004

        println("Testing NO Amex support with sample number: $sampleAmex")
        assertEquals(CardUtil.isValidCardNumber(sampleAmex), false)

        println("Testing NO Diner's Club support with sample number: $sampleDinersClub")
        assertEquals(CardUtil.isValidCardNumber(sampleDinersClub), false)

        println("Testing NO Discover support with sample number: $sampleDiscover")
        assertEquals(CardUtil.isValidCardNumber(sampleDiscover), false)
    }

    //endregion

    //region CARD CVC/CVV test methods

    @Test
    fun test_isCardCVC_Valid_false() {
        println("\n\n----- test_isCardCVC_Valid_false() -----\n")

        assertEquals(CardUtil.isValidCVC(-1), false)
        assertEquals(CardUtil.isValidCVC(12), false)
        assertEquals(CardUtil.isValidCVC(14675), false)
    }

    @Test
    fun test_isCardCVC_Valid_true() {
        println("\n\n----- test_isCardCVC_Valid_true() -----\n")

        assertEquals(CardUtil.isValidCVC(123), true)
        assertEquals(CardUtil.isValidCVC(1405), true)
        assertEquals(CardUtil.isValidCVC(975), true)
    }

    //endregion

    //region CARD CVC/CVV test methods

    @Test
    fun test_isCardExpDate_Valid_false() {
        println("\n\n----- test_isCardExpDate_Valid_false() -----\n")

        assertEquals(CardUtil.isValidExpirationDate(0, -1456), false)
        assertEquals(CardUtil.isValidExpirationDate(-654, 12), false)
        assertEquals(CardUtil.isValidExpirationDate(14, 20159), false)
        assertEquals(CardUtil.isValidExpirationDate(11, 1961), false)
    }

    @Test
    fun test_isCardExpDate_Valid_true() {
        println("\n\n----- test_isCardExpDate_Valid_true() -----\n")

        assertEquals(CardUtil.isValidExpirationDate(3, 2030), true)
        assertEquals(CardUtil.isValidExpirationDate(7, 2222), true)
        assertEquals(CardUtil.isValidExpirationDate(4, 2025), true)
    }

    //endregion

}