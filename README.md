# CardValidator

> A simple Android project for validating card details (**Card Number**, **CVC/CVV**, **Expiration Date**).
Written in **Kotlin**.

> Comes with `CardUtilTest` test class for you to see it at work in a glance.

## Validation: Card Number
- Length (supported length is minimum of 12, maximum of 19)
- Card type/brand (By default, all card types are supported but you can also set the library to support only your choice of card types)
	- Types/Brands supported: Visa, MasterCard, AmericanExpress, DinersClub, Discover, JCB
- Luhn algorithm / Modulus 10

## Validation: CVC/CVV
- Check for input to be > 0
- Length (supported length is 3-4 digits)

## Validation: Expiration Date
- Check for month input to be within the range 1-12
- Check for year input to be > 0
- Check for lapsed MM/YYYY input

## Coming soon:
- Customizable views for Card Number, CVC/CVV, and Expiration Date
