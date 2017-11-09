package spinoco.protocol.email.header

import scodec.Codec
import spinoco.protocol.email.EmailAddress
import spinoco.protocol.email.header.codec.{EmailAddressCodec, commaSeparated}

/**
  * RFC 5322 3.6.6:
  *
  * Resent fields SHOULD be added to any message that is reintroduced by
  * a user into the transport system.  A separate set of resent fields
  * SHOULD be added each time this is done.
  *
  * For instance, the "Resent-From:" field corresponds to
  * the "From:" field
  *
  */
case class ResentFrom(
  email: EmailAddress
  , others: List[EmailAddress]
) extends EmailHeaderField {
  def name: String = ResentFrom.name
}

object ResentFrom  extends HeaderDescription[ResentFrom] {
  val name: String = "Resent-From"

  val codec: Codec[ResentFrom] = {
    commaSeparated(EmailAddressCodec.codec, fold = true).xmap(
      ResentFrom.apply _ tupled, from => (from.email, from.others)
    )
  }

  def fieldCodec: Codec[EmailHeaderField] = codec.upcast

}

