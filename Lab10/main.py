from sqlalchemy import create_engine, MetaData, Table, Sequence
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy import Column, Integer, String, ForeignKey
from sqlalchemy.orm import sessionmaker

Base = declarative_base()


class Users(Base):
    __tablename__ = 'Users'
    userId = Column(Integer, Sequence('userId_seq'), primary_key=True)
    firstName = Column(String(50))
    lastName = Column(String(50))
    phoneNumber = Column(String(50))

    def __repr__(self):
        return "<User(firstName='%s', lastName='%s', phone='%s')>" % \
               (self.firstName, self.lastName, self.phoneNumber)


class Address(Base):
    __tablename__ = 'Addresses'
    addressId = Column(Integer, Sequence('addressId_seq'), primary_key=True)
    userId = Column(Integer, ForeignKey('Users.userId'), nullable=True)
    streetName = Column(String(50))
    houseNumber = Column(Integer)
    city = Column(String(50))
    postalNumber = Column(String(6))

    def __repr__(self):
        return "<Address(streetName='%s', houseNumber='%s', city='%s', postalNumber='%s')>" % \
               (self.streetName, self.houseNumber, self.city, self.postalNumber)


class Emails(Base):
    __tablename__ = 'Emails'
    userId = Column(Integer, ForeignKey('Users.userId'))
    email = Column(String, primary_key=True)

    def __repr__(self):
        return "<Emails(email='%s')>" % self.email


class Friends(Base):
    __tablename__ = "Friends"
    userId_1 = Column(Integer, ForeignKey('Users.userId'), primary_key=True)
    userId_2 = Column(Integer, ForeignKey('Users.userId'), primary_key=True)

    def __repr__(self):
        return "<Friends(userId_1='%s', userId_1='%s')>" % (self.userId_1 , self.userId_2)


def add_user(session, firstName, lastName, phoneNumber, addresses, emails, friends):
    ed_user = Users(firstName=firstName, lastName=lastName, phoneNumber=phoneNumber)
    session.add(ed_user)
    session.commit()
    id = ed_user.userId
    addr = []
    mails = []
    friend_list = []
    for address in addresses:
        addr.append(Address(userId=id, streetName=address.streetName, houseNumber=address.houseNumber,
                            city=address.city, postalNumber=address.postalNumber))
    session.add_all(addr)

    for email in emails:
        mails.append(Emails(userId=ed_user.userId, email=email))
    session.add_all(mails)

    for friend in friends:
        friend_list.append(Friends(userId_1=ed_user.userId, userId_2=friend))
    session.add_all(friend_list)

    session.commit()


def select_by_first_name(session, firstName):
    for instance in session.query(Users, Address, Emails, Friends).order_by(Users.userId). \
            filter(Users.userId == Address.userId).filter(Users.userId == Emails.userId).filter(
            Users.userId == Friends.userId_1).filter(Users.firstName == firstName):
        print(instance)


def select_by_last_name(session, lastName):
    for instance in session.query(Users, Address, Emails, Friends).order_by(Users.userId).\
            filter(Users.userId == Address.userId).filter(Users.userId == Emails.userId).filter(
            Users.userId == Friends.userId_1).filter(Users.lastName == lastName):
        print(instance)


def select_all(session):
    for instance in session.query(Users, Address, Emails, Friends).order_by(Users.userId).\
            filter(Users.userId == Emails.userId).filter(Users.userId == Friends.userId_1).filter(
            Users.userId == Address.userId):
        print(instance)


def main():
    print("SQL Alchemy")
    engine = create_engine("sqlite:///osoby.db", echo=True)
    Base.metadata.create_all(engine)

    Session = sessionmaker(bind=engine)
    session = Session()

    address1 = Address(streetName="Ulica", houseNumber=1, city="Ruchocinek", postalNumber="12-456")
    address2 = Address(streetName="Zielona", houseNumber=2, city="Poznań", postalNumber="43-456")
    addresses = [address1, address2]

    add_user(session, "Bogdan", "Biały", "12345678", addresses, ["mail@op.com", "mail2@op.com"], [2, 3])
    add_user(session, "Marjan", "Biały", "32345678", addresses, ["mail3@op.com", "mail4@op.com"], [1, 3])
    add_user(session, "Bożena", "Biała", "22345678", addresses, ["mai5@op.com", "mail6@op.com"], [1, 2])

    # select_all(session)
    select_by_last_name(session, "Biały")
    # select_by_first_name(session, "Bożena")


if __name__ == "__main__":
    main()
