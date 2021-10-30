//
// Copyright (c) 2019 Adyen N.V.
//
// This file is open source and available under the MIT license. See the LICENSE file for more info.
//

import Adyen
import Foundation

internal struct PaymentMethodsRequest: Request {
    
    internal typealias ResponseType = PaymentMethodsResponse
    
    internal let path = "payment/adyen/payment-methods?channel=iOS&countryCode=\(PaymentsData.countryCode)&amount[currency]=\(PaymentsData.amount.currencyCode)&amount[value]=\(PaymentsData.amount.value)&shopperLocale=\(PaymentsData.shopperLocale)"
    internal let type = "PAYMENT_METHODS"
    
    internal func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(PaymentsData.merchantAccount, forKey: .merchantAccount)
        try container.encode(PaymentsData.countryCode, forKey: .countryCode)
        try container.encode(PaymentsData.shopperReference, forKey: .shopperReference)
        try container.encode(["value": PaymentsData.amount.value,"currency":PaymentsData.amount.currencyCode], forKey: .amount)
        try container.encode(PaymentsData.shopperLocale, forKey: .shopperLocale)
        try container.encode("iOS", forKey: .channel)
    }

    
    internal enum CodingKeys: CodingKey {
        case merchantAccount
        case shopperReference
        case additionalData
        case allowedPaymentMethods
        case amount
        case blockedPaymentMethods
        case countryCode
        case shopperLocale
        case channel
    }
    
}

internal struct PaymentMethodsResponse: Response {
    
    internal let paymentMethods: PaymentMethods
    
    internal init(from decoder: Decoder) throws {
        self.paymentMethods = try PaymentMethods(from: decoder)
    }
    
}

